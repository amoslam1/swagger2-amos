package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:33
 * 内容：Role Object
 * ===============================
*/
public class SaveRoleRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 名称
	 */
	@Length(max = 128,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String name;

	/**
	 * 备注
	 */
	@Length(max = 1024,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String remarks;

	/**
	 * 创建者
	 */
	@Length(max = 64,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String creator;

	/**
	 * 修改者
	 */
	@Length(max = 64,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String operator;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRemarks(String remarks){
		this.remarks = remarks;
	}

	public String getRemarks(){
		return remarks;
	}

	public void setCreator(String creator){
		this.creator = creator;
	}

	public String getCreator(){
		return creator;
	}

	public void setOperator(String operator){
		this.operator = operator;
	}

	public String getOperator(){
		return operator;
	}

}

