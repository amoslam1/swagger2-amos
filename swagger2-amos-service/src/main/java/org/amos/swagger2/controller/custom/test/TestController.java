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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "测试")
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private RedisUtils redisUtils;
	
	@ApiOperation(value="测试成功",notes="成功请求响应信息会被包装，输出统一格式")
	@PostMapping("/success")
	@ResponseBody
	public String success() {

		return "success";
	}
	
	@ApiOperation(value="测试Redis超时时间",notes="响应Redis超时时间")
	@PostMapping("/redisTimeout")
	@ResponseBody
	public Long redisTimeout() {

		return redisUtils.getExpire("YW1vcw==");
	}
	
	@ApiOperation(value="测试业务异常",notes="响应异常信息会被包装，输出统一格式")
	@PostMapping("/businessException")
	@ResponseBody
	public String businessException() {

		throw new BusinessException(ErrorCode.SUCCESS);
	}
	
	@ApiOperation(value="测试校验",notes="校验信息会被包装，输出统一格式")
	@PostMapping("/validator")
	@ResponseBody
	public String validator(@RequestBody PageRequest<ValidatorRequest> request) {
		
		throw new BusinessException(ErrorCode.ERR_DATA_EMPTY_ERROR);
	}

	@ApiOperation(value="测试Spring Security权限控制",notes="校验是否被权限控制")
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
