package org.amos.swagger2.controller.custom.test;

import org.amos.framework.exception.BusinessException;
import org.amos.framework.exception.bean.ErrorCode;
import org.amos.framework.request.PageRequest;
import org.amos.swagger2.common.redis.RedisUtils;
import org.amos.swagger2.controller.bean.request.custom.test.ValidatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private RedisUtils redisUtils;
	
	@PostMapping("/success")
	@ResponseBody
	public String success() {

		return "success";
	}
	
	@PostMapping("/redisTimeout")
	@ResponseBody
	public Long redisTimeout() {

		return redisUtils.getExpire("YW1vcw==");
	}
	
	@PostMapping("/businessException")
	@ResponseBody
	public String businessException() {

		throw new BusinessException(ErrorCode.SUCCESS);
	}
	
	@PostMapping("/validator")
	@ResponseBody
	public String validator(@RequestBody PageRequest<ValidatorRequest> request) {
		
		throw new BusinessException(ErrorCode.ERR_DATA_EMPTY_ERROR);
	}

	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/getInfo")
    public String getRole(){
    	
        return "测试是否拥有ADMIN角色权限";
    }
	
	@PreAuthorize("hasAuthority('userInfo')")
    @PostMapping(value = "/getPermissions")
    public String getPermissions(){
    	
        return "测试是否拥有userInfo权限";
    }
}
