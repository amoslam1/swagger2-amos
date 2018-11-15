package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import javax.validation.constraints.NotNull;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:33
 * 内容：Permissions Object
 * ===============================
*/
public class UpdatePermissionsRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 自增
	 */
	@NotNull(message = "{params.is.not.empty}")
	private Long id;

	/**
	 * 中文简体权限名
	 */
	private String zhCnName;

	/**
	 * 中文繁体权限名
	 */
	private String zhHkName;

	/**
	 * 英文权限名
	 */
	private String enName;

	/**
	 * 权限名
	 */
	private String permissionsName;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 访问地址
	 */
	private String url;

	/**
	 * 父级菜单ID,-1代表一级菜单
	 */
	private Long parentId;

	/**
	 * 是否禁用（0：正常、1：禁用）
	 */
	private Byte isDisable;

	/**
	 * 优先级
	 */
	private Byte priority;

	/**
	 * 1：该权限是permissions,2:该权限是controller
	 */
	private String pmsOrCtl;

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

	public void setZhCnName(String zhCnName){
		this.zhCnName = zhCnName;
	}

	public String getZhCnName(){
		return zhCnName;
	}

	public void setZhHkName(String zhHkName){
		this.zhHkName = zhHkName;
	}

	public String getZhHkName(){
		return zhHkName;
	}

	public void setEnName(String enName){
		this.enName = enName;
	}

	public String getEnName(){
		return enName;
	}

	public void setPermissionsName(String permissionsName){
		this.permissionsName = permissionsName;
	}

	public String getPermissionsName(){
		return permissionsName;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setRemarks(String remarks){
		this.remarks = remarks;
	}

	public String getRemarks(){
		return remarks;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setParentId(Long parentId){
		this.parentId = parentId;
	}

	public Long getParentId(){
		return parentId;
	}

	public void setIsDisable(Byte isDisable){
		this.isDisable = isDisable;
	}

	public Byte getIsDisable(){
		return isDisable;
	}

	public void setPriority(Byte priority){
		this.priority = priority;
	}

	public Byte getPriority(){
		return priority;
	}

	public void setPmsOrCtl(String pmsOrCtl){
		this.pmsOrCtl = pmsOrCtl;
	}

	public String getPmsOrCtl(){
		return pmsOrCtl;
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

