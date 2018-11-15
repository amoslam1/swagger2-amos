package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 18:58:32
 * 内容：UserRoleRel Object
 * ===============================
*/
public class SaveUserRoleRelRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID（用户表外键）
	 */
	@Length(max = 32,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String userId;

	/**
	 * 角色ID（角色表外键）
	 */
	@NotNull(message = "{params.is.not.empty}")
	private Long roleId;

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

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	public Long getRoleId(){
		return roleId;
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

