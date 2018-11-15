package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 18:58:33
 * 内容：Permissions Object
 * ===============================
*/
public class SavePermissionsRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 中文简体权限名
	 */
	@Length(max = 256,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String zhCnName;

	/**
	 * 中文繁体权限名
	 */
	@Length(max = 256,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String zhHkName;

	/**
	 * 英文权限名
	 */
	@Length(max = 256,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String enName;

	/**
	 * 权限名
	 */
	@Length(max = 256,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String permissionsName;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 备注
	 */
	@Length(max = 1024,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String remarks;

	/**
	 * 访问地址
	 */
	@Length(max = 256,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String url;

	/**
	 * 父级菜单ID,-1代表一级菜单
	 */
	@NotNull(message = "{params.is.not.empty}")
	private Long parentId;

	/**
	 * 优先级
	 */
	@NotNull(message = "{params.is.not.empty}")
	private Byte priority;

	/**
	 * 1：该权限是permissions,2:该权限是controller
	 */
	@Length(max = 2,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String pmsOrCtl;

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

