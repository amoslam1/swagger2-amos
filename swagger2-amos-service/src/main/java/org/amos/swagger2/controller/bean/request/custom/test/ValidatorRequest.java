package org.amos.swagger2.controller.bean.request.custom.test;

import org.amos.framework.request.BaseRequest;
import org.amos.framework.validator.constants.ValidatorConstant;
import org.hibernate.validator.constraints.NotEmpty;

public class ValidatorRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 858899841605395734L;
	
	@NotEmpty(message=ValidatorConstant.PARAMS_IS_NOT_EMPTY)
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
