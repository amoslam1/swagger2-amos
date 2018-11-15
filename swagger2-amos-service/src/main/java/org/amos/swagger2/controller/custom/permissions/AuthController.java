package org.amos.swagger2.controller.custom.permissions;

import org.amos.framework.utils.ConvertUtils;
import org.amos.swagger2.controller.bean.request.custom.permissions.LoginRequest;
import org.amos.swagger2.controller.bean.request.custom.permissions.RegisterRequest;
import org.amos.swagger2.model.auto.permissions.User;
import org.amos.swagger2.service.custom.permissions.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	/**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/login")
    public String login(@RequestBody LoginRequest login) {
    	
        return userService.login(login.getUsername(), login.getPassword());
    }

    /**
     * 用户注册
     *
     * @param user          用户信息
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/register")
    public Boolean register(@RequestBody RegisterRequest request){
    	
    	User user = ConvertUtils.convertObject(request, User.class);
    	userService.register(user);
    	
        return true;
    }

    /**
     * 刷新密钥
     *
     * @param authorization 原密钥
     * @return 新密钥
     * @throws AuthenticationException 错误信息
     */
    @GetMapping(value = "/refreshToken")
    public String refreshToken(@RequestHeader String authorization){
    	
        return userService.refreshToken(authorization);
    }
    
}
