package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import javax.validation.constraints.NotNull;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 18:58:33
 * 内容：RolePermissionsRel Object
 * ===============================
*/
public class UpdateRolePermissionsRelRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 自增
	 */
	@NotNull(message = "{params.is.not.empty}")
	private Long id;

	/**
	 * 用户ID（用户表外键）
	 */
	private Long roleId;

	/**
	 * 权限ID（权限键）
	 */
	private Long permissionsId;

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

	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	public Long getRoleId(){
		return roleId;
	}

	public void setPermissionsId(Long permissionsId){
		this.permissionsId = permissionsId;
	}

	public Long getPermissionsId(){
		return permissionsId;
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

