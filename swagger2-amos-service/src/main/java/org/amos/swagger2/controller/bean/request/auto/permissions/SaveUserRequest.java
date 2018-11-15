package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 18:58:32
 * 内容：User Object
 * ===============================
*/
public class SaveUserRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	@Length(max = 64,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String username;

	/**
	 * 密码
	 */
	@Length(max = 128,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String password;

	/**
	 * 盐（随机数）
	 */
	@Length(max = 32,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String salt;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 名称
	 */
	@Length(max = 64,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String name;

	/**
	 * 头像URL
	 */
	@Length(max = 256,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String portraitUrl;

	/**
	 * 用户会话ID
	 */
	private String sessionId;

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

	public void setSalt(String salt){
		this.salt = salt;
	}

	public String getSalt(){
		return salt;
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

	public void setSessionId(String sessionId){
		this.sessionId = sessionId;
	}

	public String getSessionId(){
		return sessionId;
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

