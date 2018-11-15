package org.amos.swagger2.controller.bean.request.auto.permissions;

import org.amos.framework.request.BaseRequest;
import javax.validation.constraints.NotNull;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 18:58:33
 * 内容：UserRoleRel Object
 * ===============================
*/
public class GetByIdUserRoleRelRequest  extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/**
	 * 自增
	 */
	@NotNull(message = "{params.is.not.empty}")
	private Long id;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

}

