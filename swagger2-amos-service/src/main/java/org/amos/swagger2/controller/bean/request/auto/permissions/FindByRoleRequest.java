package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import java.util.Date;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:33
 * 内容：Role Object
 * ===============================
*/
public class FindByRoleRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 自增
	 */
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

	/**
	 * 创建时间
	 */
	private Date createdTime;

	/**
	 * 修改时间
	 */
	private Date modifedTime;

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

	public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}

	public Date getCreatedTime(){
		return createdTime;
	}

	public void setModifedTime(Date modifedTime){
		this.modifedTime = modifedTime;
	}

	public Date getModifedTime(){
		return modifedTime;
	}

}

