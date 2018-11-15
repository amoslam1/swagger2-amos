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
public class GetByIdUserRequest  extends BaseRequest{

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

