package org.amos.swagger2.controller.bean.request.custom.swagger2;

import java.io.Serializable;

import org.amos.framework.validator.constants.ValidatorConstant;
import org.hibernate.validator.constraints.NotEmpty;

public class CollectApiDocsRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1776556637401934091L;

	/**
	 * 拥有者，必须是项目经理级以上
	 */
	@NotEmpty(message = ValidatorConstant.PARAMS_IS_NOT_EMPTY)
	private String owner;
	
	/**
	 * 组织编码
	 */
	@NotEmpty(message = ValidatorConstant.PARAMS_IS_NOT_EMPTY)
	private String organizationCode;
	
	/**
	 * Swagger2 数据结构
	 */
	@NotEmpty(message = ValidatorConstant.PARAMS_IS_NOT_EMPTY)
	private String swagger2Data;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getSwagger2Data() {
		return swagger2Data;
	}

	public void setSwagger2Data(String swagger2Data) {
		this.swagger2Data = swagger2Data;
	}
	
	
}
