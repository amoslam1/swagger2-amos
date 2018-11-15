package org.amos.swagger2.controller.bean.request.custom.permissions;

import org.amos.framework.request.BaseRequest;
import org.amos.framework.validator.constants.ValidatorConstant;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8262457015641497176L;

	/**
	 * 用户名
	 */
	@NotEmpty(message = ValidatorConstant.PARAMS_IS_NOT_EMPTY)
	private String username;
	
	/**
	 * 密码
	 */
	@NotEmpty(message = ValidatorConstant.PARAMS_IS_NOT_EMPTY)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
