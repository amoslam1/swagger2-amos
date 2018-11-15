package org.amos.swagger2.service.custom.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.amos.framework.exception.BusinessException;
import org.amos.framework.exception.SecurityException;
import org.amos.framework.exception.bean.ErrorCode;
import org.amos.framework.utils.Base64Utils;
import org.amos.swagger2.common.constants.Constants;
import org.amos.swagger2.common.redis.RedisHandler;
import org.amos.swagger2.common.redis.RedisUtils;
import org.amos.swagger2.model.auto.user.User;
import org.amos.swagger2.service.auto.user.UserAutoService;
import org.amos.swagger2.service.custom.user.UserService;
import org.amos.swagger2.springboot.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private JwtTokenUtils jwtTokenUtils;
	
	@Autowired
	private UserAutoService userAutoService;
	
	@Autowired
	private RedisUtils redisUtils;
	
	@Value("${jwt.expiresSecond}")
	private Long expiresSecond;

    @Override
    public String login(String username, String password) {
    	
        User user = userAutoService.getBy("username", username);
        if(user == null){

            Object objUsername = username;
            throw new BusinessException(ErrorCode.ERR_USERNAME_NOT_FOUND,objUsername);
        }
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, user.getPassword())){
        	
        	throw new BusinessException(ErrorCode.ERR_USERNAME_OR_PASSWORD_INCORRECT);
        }
        
        String token = this.getToken(user);
        
        return token;
    }
    
    /**
     * 根据用户信息获取Token
     * 如果该用户已经登录过则直接返回token
     * 否则创建新token
     * @param user 用户信息
     * @return
     */
    private String getToken(User user){

        String base64Username = Base64Utils.encode(user.getUsername());

        Map<Object, Object> map = new HashMap<Object, Object>();
        
        String redisKey = RedisHandler.getAuthKey(base64Username);
        
        if(redisUtils.hasKey(redisKey)){
        	
        	map = redisUtils.hmget(redisKey);
        	
        	return map.get(Constants.AUTH_TOKEN).toString();
        }

        String token = jwtTokenUtils.generateToken(user);
        
        map.put(Constants.AUTH_TOKEN, token);
        map.put(Constants.AUTH_INFO, user);
        
        Boolean bool = redisUtils.hmset(redisKey, map,expiresSecond);
        
        if(!bool){
        	
        	throw new SecurityException(ErrorCode.ERR_AUTH_FAILED);
        }
        
        return token;
    }

    @Override
    public void register(User user) {
    	
        String username = user.getUsername();
        
        User dbUser = userAutoService.getBy("username", username);
        if(null != dbUser){
        	
        	Object objUsername = username;
        	throw new BusinessException(ErrorCode.ERR_USERNAME_IS_EXIST,objUsername);
        }
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        
        userAutoService.save(user);
    }
    
    public static void main(String[] args) {
		
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("123456");
    	System.out.println(password);
	}

    @Override
    public String refreshToken(String oldToken) {
    	
        String token = oldToken.substring("Bearer ".length());
        if (!jwtTokenUtils.isTokenExpired(token)) {
        	
            return jwtTokenUtils.refreshToken(token);
        }
        return "error";
    }
}
