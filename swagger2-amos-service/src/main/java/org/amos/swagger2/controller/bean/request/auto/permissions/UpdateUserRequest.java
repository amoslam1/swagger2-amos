package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:33
 * 内容：User Object
 * ===============================
*/
public class UpdateUserRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 随机32位
	 */
	@Length(max = 32,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 头像URL
	 */
	private String portraitUrl;

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

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPortraitUrl(String portraitUrl){
		this.portraitUrl = portraitUrl;
	}

	public String getPortraitUrl(){
		return portraitUrl;
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

