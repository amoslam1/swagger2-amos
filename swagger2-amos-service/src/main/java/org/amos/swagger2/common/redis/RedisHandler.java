package org.amos.swagger2.common.redis;

import org.amos.swagger2.common.constants.Constants;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018年11月14日上午10:23:26
 * 内容：
 * ===============================
 */
public class RedisHandler {

	/**
	 * 获取授权key
	 * @param key
	 * @return
	 */
	public static String getAuthKey(String key){
		
		String redisKey = Constants.AUTH_REDIS_KEY_PREFIX + key;
		
		return redisKey;
	}
	
	/**
	 * 获取权限授权Redis key
	 * @param key
	 * @return
	 */
	public static String getAuthorizeKey(String key){
		
		String redisKey = Constants.AUTHORIZE_REDIS_KEY_PREFIX + key;
		
		return redisKey;
	}
}
