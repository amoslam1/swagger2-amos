package org.amos.swagger2.springboot.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.util.HtmlUtils;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

public class XSSHttpRequestWrapper extends HttpServletRequestWrapper {
	
	
	// 不过滤的字段
	List<String> pnames = Arrays.asList();

	// 没被包装过的HttpServletRequest（特殊场景，需要自己过滤）
	HttpServletRequest orgRequest;

	public XSSHttpRequestWrapper(HttpServletRequest request) {
		super(request);
		orgRequest = request;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		// 非json类型，直接返回
		if (!MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(super.getHeader(HttpHeaders.CONTENT_TYPE))) {
			return super.getInputStream();
		}

		String json = CharStreams.toString(new InputStreamReader(
				super.getInputStream(), Charsets.UTF_8));
		if (StringUtils.isBlank(json)) {
			return super.getInputStream();
		}

		json = xssEncode(json);
		final ByteArrayInputStream bis = new ByteArrayInputStream(json.getBytes("utf-8"));
		return new ServletInputStream() {
			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener readListener) {

			}

			@Override
			public int read() throws IOException {
				return bis.read();
			}
		};
	}

	@Override
	public String getParameter(String name) {
		
		if(pnames.contains(name)) {
			return super.getParameter(name);
		}
		
		String value = super.getParameter(xssEncode(name));
		if (StringUtils.isNotBlank(value)) {
			value = xssEncode(value);
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		
		String[] parameters = super.getParameterValues(name);
		if (parameters == null || parameters.length == 0) {
			return null;
		}

		for (int i = 0; i < parameters.length; i++) {
			if(pnames.contains(name)) {
				parameters[i] = parameters[i];
			}else {
				parameters[i] = xssEncode(parameters[i]);
			}
		}
		return parameters;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = new LinkedHashMap<String,String[]>();
		Map<String, String[]> parameters = super.getParameterMap();
		for (String key : parameters.keySet()) {
			String[] values = parameters.get(key);
			for (int i = 0; i < values.length; i++) {
				values[i] = xssEncode(values[i]);
			}
			map.put(key, values);
		}
		return map;
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(xssEncode(name));
		if (StringUtils.isNotBlank(value)) {
			value = xssEncode(value);
		}
		return value;
	}

	private String xssEncode(String input) {
		
		return HtmlUtils.htmlEscape(input);
	}

	public HttpServletRequest getOrgRequest() {
		return orgRequest;
	}

	public static HttpServletRequest getOrgRequest(HttpServletRequest request) {
		if (request instanceof XSSHttpRequestWrapper) {
			return ((XSSHttpRequestWrapper) request).getOrgRequest();
		}

		return request;
	}
}
