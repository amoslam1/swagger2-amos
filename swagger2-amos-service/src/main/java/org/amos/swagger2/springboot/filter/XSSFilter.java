package org.amos.swagger2.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XSSFilter implements Filter {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;


    	//TODO 请勿删除该无内容输出的LOG，重写了log4j2输出traceId，每个请求的第一行都不打印traceId，固用此顶替第一行LOG，使之打印traceId打印正常
    	LOGGER.info("");
		LOGGER.info("<----------------------------【{}】【START】---------------------------->",httpRequest.getRequestURI());
		
		chain.doFilter(new XSSHttpRequestWrapper(httpRequest), response);
		
		LOGGER.info("<----------------------------【{}】【END】---------------------------->",httpRequest.getRequestURI());
	}

	@Override
	public void destroy() {
		
		
	}


}
