package org.amos.swagger2.springboot.http;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018年9月27日下午1:38:49
 * 内容：HTTP上下文
 * ===============================
 */
public class HttpContext {

	/**
	 * 获取当前请求上下文HttpServletRequest对象
	 * @return HttpServletRequest
	 */ 
	public static HttpServletRequest getRequest() {
		
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		
		return requestAttributes == null ? null : requestAttributes.getRequest();
	}
}
