package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import javax.validation.constraints.NotNull;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 18:58:32
 * 内容：Role Object
 * ===============================
*/
public class UpdateRoleRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 自增
	 */
	@NotNull(message = "{params.is.not.empty}")
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 是否禁用（0：正常、1：禁用）
	 */
	private Byte isDisable;

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

	public void setIsDisable(Byte isDisable){
		this.isDisable = isDisable;
	}

	public Byte getIsDisable(){
		return isDisable;
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

