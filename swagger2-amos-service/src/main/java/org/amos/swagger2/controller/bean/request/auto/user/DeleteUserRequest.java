package org.amos.swagger2.controller.bean.request.auto.user;

import org.amos.framework.request.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * ===============================
 * 浣滆�咃細amos lam
 * 鏃堕棿锛�2018-11-04 02:08:39
 * 鍐呭锛�User Object
 * ===============================
*/
public class DeleteUserRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 随机32位
	 */
	@Length(max = 32,message = "{params.length.must.be.more.than.value}")
	@NotEmpty(message = "{params.is.not.empty}")
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

}

