package org.amos.swagger2.springboot.configurer;

import java.util.Arrays;
import java.util.Map;

import org.amos.swagger2.common.constants.Constants;
import org.amos.swagger2.common.redis.RedisUtils;
import org.amos.swagger2.springboot.filter.JwtAuthenticationTokenFilter;
import org.amos.swagger2.springboot.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

@Configuration
public class JWTAuthConfigurer {

	@Autowired
	private JwtTokenUtils jwtTokenUtils;

	@Autowired
	private RedisUtils redisUtils;
	
	@Value("${jwt.expiresSecond}")
	private Long expiresSecond;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * jtw token验证
	 */
	@Bean
	public FilterRegistrationBean jwtAuthRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtAuthenticationTokenFilter(jwtTokenUtils,redisUtils,expiresSecond,userDetailsService));
		filterRegistrationBean.setOrder(Integer.MAX_VALUE - 1);
		filterRegistrationBean.setEnabled(true);
		filterRegistrationBean.addUrlPatterns("/*");
		Map<String, String> initParameters = Maps.newHashMap();
		
		initParameters.put(Constants.EXCLUDES_URL, 
				JSONObject.toJSONString(
						Arrays.asList(
								"/auth/login",
								"/auth/register",
								"/swagger-ui.html",
								"/webjars/**"
						)
				)
		);
		filterRegistrationBean.setInitParameters(initParameters);
		return filterRegistrationBean;
	}

}
