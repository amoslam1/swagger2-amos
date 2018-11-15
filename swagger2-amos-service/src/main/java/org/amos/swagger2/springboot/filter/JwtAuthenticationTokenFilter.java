package org.amos.swagger2.springboot.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.amos.framework.exception.bean.ErrorCode;
import org.amos.framework.utils.Base64Utils;
import org.amos.framework.utils.RegUtils;
import org.amos.swagger2.common.constants.Constants;
import org.amos.swagger2.common.redis.RedisHandler;
import org.amos.swagger2.common.redis.RedisUtils;
import org.amos.swagger2.model.auto.user.User;
import org.amos.swagger2.model.custom.permissions.PMSUser;
import org.amos.swagger2.springboot.utils.JwtTokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.alibaba.fastjson.JSONObject;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018年11月13日上午10:50:38
 * 内容：Spring secuript + JWT 权限验证
 * ===============================
 */
public class JwtAuthenticationTokenFilter implements Filter {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	private JwtTokenUtils jwtTokenUtils;
	
	private RedisUtils redisUtils;
	
	private UserDetailsService userDetailsService;
	
	private Long expiresSecond;
	
	public JwtAuthenticationTokenFilter(JwtTokenUtils jwtTokenUtils,RedisUtils redisUtils,Long expiresSecond,UserDetailsService userDetailsService) {
	
		this.jwtTokenUtils = jwtTokenUtils;
		this.redisUtils = redisUtils;
		this.expiresSecond = expiresSecond;
		this.userDetailsService = userDetailsService;
	}

	
    protected List<String> excludes = new ArrayList<String>();

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)servletRequest;
		
		Boolean excludes = isInclude(request.getRequestURI());
		if (excludes){

			chain.doFilter(servletRequest, servletResponse);
			return ;
		}
		
    	String authHeader = request.getHeader(Constants.JWT_AUTHORIZATION);
        String tokenPrefix = Constants.JWT_TOKEN_PREFIX;
        
        LOGGER.info("Jwt auth header is {}",authHeader);
        if(authHeader == null || !authHeader.startsWith(tokenPrefix)){
        	
        	chain.doFilter(servletRequest, servletResponse);
			return ;
        }
        	
        String authToken = authHeader.substring(tokenPrefix.length());
        String username = jwtTokenUtils.getUsernameFromToken(authToken);
        
        LOGGER.info("Jwt auth parse token get username is {}",username);
        
        if(StringUtils.isEmpty(username)){
        	
        	LOGGER.info("Jwt auth username is empty");
        	throw new org.amos.framework.exception.SecurityException(ErrorCode.ERR_INVALID_TOKEN);
        }
        
        String base64Username = Base64Utils.encode(username);
        String authRedisKey = RedisHandler.getAuthKey(base64Username);
        if(!redisUtils.hasKey(authRedisKey)){
        	
        	LOGGER.info("Jwt auth token overdue");
        	throw new org.amos.framework.exception.SecurityException(ErrorCode.ERR_INVALID_TOKEN);
        }
        
        Map<Object, Object> map = redisUtils.hmget(authRedisKey);
        
        Object currentToken = map.get(Constants.AUTH_TOKEN);
        if(null != currentToken && !authToken.equalsIgnoreCase(currentToken.toString())){
        	
        	LOGGER.info("Jwt auth token atypism");
        	throw new org.amos.framework.exception.SecurityException(ErrorCode.ERR_INVALID_TOKEN);
        }
        redisUtils.expire(authRedisKey, expiresSecond);
        
        User user = (User) map.get(Constants.AUTH_INFO);
        
        this.createSecuript(user, request,base64Username);
        
        chain.doFilter(servletRequest, servletResponse);
	}
	
	private void createSecuript(User user,HttpServletRequest request,String base64Username){
        
		String redisKey = RedisHandler.getAuthorizeKey(base64Username);
		PMSUser userDetails = null;
		if(redisUtils.hasKey(redisKey)){
			
			Object userJson = redisUtils.get(redisKey);
			if(null == userJson){
				
				LOGGER.info("Jwt auth Create secuript info is empty");
				throw new org.amos.framework.exception.SecurityException(ErrorCode.ERR_INVALID_TOKEN);
			}
			userDetails = JSONObject.parseObject(userJson.toString(), PMSUser.class);
			redisUtils.expire(redisKey, expiresSecond);
		}else{

			userDetails = (PMSUser) userDetailsService.loadUserByUsername(user.getUsername());
			redisUtils.set(redisKey, JSONObject.toJSONString(userDetails), expiresSecond);
		}
        
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		excludes = JSONObject.parseArray(filterConfig.getInitParameter(Constants.EXCLUDES_URL), String.class);
		
		LOGGER.info("Jwt auth init excludes is {}",JSONObject.toJSONString(excludes));
	}

	private boolean isInclude(String url) {

		for (String pattern : excludes) {

			String regPath = RegUtils.getRegPath(pattern);
			if (Pattern.compile(regPath).matcher(url).matches()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {
		
	}
}
