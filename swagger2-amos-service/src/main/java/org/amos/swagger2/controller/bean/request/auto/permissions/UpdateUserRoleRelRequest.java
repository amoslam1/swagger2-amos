package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import javax.validation.constraints.NotNull;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 18:58:32
 * 内容：UserRoleRel Object
 * ===============================
*/
public class UpdateUserRoleRelRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 自增
	 */
	@NotNull(message = "{params.is.not.empty}")
	private Long id;

	/**
	 * 用户ID（用户表外键）
	 */
	private String userId;

	/**
	 * 角色ID（角色表外键）
	 */
	private Long roleId;

	/**
	 * 创建者
	 */
	private String creator;

	/**
	 * 修改者
	 */
	private String operator;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

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

