package org.amos.swagger2.common.constants;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018年8月23日下午4:14:13
 * 内容：项目常量
 * ===============================
 */
public interface Constants extends org.amos.framework.constants.Constants{

	/**
	 * 签名key
	 */
	String SIGNING_KEY = "spring-security-@Jwt!&Secret^#";
	
	/**
	 * 国际化语言头部名
	 */
	String LANGUAGE_HEADER_NAME = "Accept-Language";
	
	/**
	 * 国际化语言默认中文简体
	 */
	String LANGUAGE_DEFAULT = "zh_CN";
	
	/**
	 * JWT 生成的token存放位置
	 */
	String JWT_AUTHORIZATION = "Authorization";
	
	/**
	 * JWT token 前缀
	 */
	String JWT_TOKEN_PREFIX = "Bearer ";
	
	/**
	 * 系统异常跳转
	 */
	String SYSTEM_EXCEPTION = "/error";
	
	/**
	 * filter 排除excludes
	 */
	String EXCLUDES_URL = "excludes";
	
	/**
	 * 授权token
	 */
	String AUTH_TOKEN = "authToken";
	
	/**
	 * 授权信息
	 */
	String AUTH_INFO = "authInfo";
	
	/**
	 * 授权Redis前缀
	 */
	String AUTH_REDIS_KEY_PREFIX = "auth_token_";
	
	/**
	 * 权限授权信息Redis前缀
	 */
	String AUTHORIZE_REDIS_KEY_PREFIX = "authorize_";
}
