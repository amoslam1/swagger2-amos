package org.amos.swagger2.springboot.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.amos.framework.exception.bean.ErrorCode;
import org.amos.swagger2.model.auto.permissions.User;
import org.amos.swagger2.model.custom.permissions.PMSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtils implements Serializable{

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4210754164820999021L;
	
	@Value("${jwt.auth.secret}")
	private String authSecret;

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        
    	/**
    	 * 使用Redis 存储 token
    	 * Date expirationDate = new Date(System.currentTimeMillis() + 2592000L * 1000);
         * return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, authSecret).compact();
    	 */
    	
    	return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, authSecret).compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        try {
        	
        	Claims claims = Jwts.parser().setSigningKey(authSecret).parseClaimsJws(token).getBody();
        	
        	return claims;
        } catch (Exception e) {
            
        	LOGGER.error("Get Claims from token throw exception is {}",e);
        	throw new org.amos.framework.exception.SecurityException(ErrorCode.ERR_INVALID_TOKEN);
        }
    }

    /**
     * 生成令牌
     *
     * @param userDetails 用户
     * @return 令牌
     */
    public String generateToken(User user) {
    	
    	/***
    	 * iss: jwt签发者
    	 * sub: jwt所面向的用户
    	 * aud: 接收jwt的一方
    	 * exp: jwt的过期时间，这个过期时间必须要大于签发时间
    	 * nbf: 定义在什么时间之前，该jwt都是不可用的.
    	 * iat: jwt的签发时间
    	 * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
    	 */
    	
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", user.getUsername());
        claims.put("iat", System.currentTimeMillis());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        try {
        	
            Claims claims = getClaimsFromToken(token);
            String username = claims.getSubject();
            
            return username;
        } catch (org.amos.framework.exception.SecurityException e) {
            
        	//该异常为手动抛出，异常信息已打印，透传即可
        	throw e;
        } catch (Exception e) {
            
        	LOGGER.error("Get username from token throw exception is {}",e);
        	throw new org.amos.framework.exception.SecurityException(ErrorCode.ERR_INVALID_TOKEN);
        }
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
    	
        try {
        	
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
            
        } catch (Exception e) {
        	
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userDetails 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
    	PMSUser user = (PMSUser) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

}
