package org.amos.swagger2.controller.bean.request.auto.user;

import org.amos.framework.request.BaseRequest;
import java.util.Date;

/**
 * ===============================
 * 浣滆�咃細amos lam
 * 鏃堕棿锛�2018-11-04 02:08:39
 * 鍐呭锛�User Object
 * ===============================
*/
public class FindByUserRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 随机32位
	 */
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
	 * 盐（随机数）
	 */
	private String salt;

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
	 * 用户会话ID
	 */
	private String sessionId;

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

	public void setIsDisable(Byte isDisable){
		this.isDisable = isDisable;
	}

	public Byte getIsDisable(){
		return isDisable;
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

