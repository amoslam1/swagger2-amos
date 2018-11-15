package org.amos.swagger2.common.global;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.amos.framework.http.HttpUtils;
import org.amos.framework.response.ExcludeResponse;
import org.amos.framework.utils.RegUtils;

public class GlobalHttpMessageConverter extends org.amos.framework.global.GlobalHttpMessageConverter{

	private List<String> FILTERLIST = new ArrayList<String>(
			Arrays.asList(
					"/swagger/**",
					"/swagger-*/**",
					"/swagger-*",
					"/v2/**"
					)
			);
	
	@Override
	protected Boolean customExclude(Object obj) {
		
		Boolean bool = (
				!(obj instanceof ExcludeResponse) 
				&& !(obj instanceof Map) 
				&& !this.excludeFilter()
				);
		return bool;
	}
	
	/**
	 * 排除url拦截
	 * @return
	 */
	private Boolean excludeFilter(){

		HttpServletRequest request = HttpUtils.getRequest();
		if(RegUtils.urlCompile(FILTERLIST, request.getRequestURI())){
			
			return true;
		}
		return false;
	}
}
