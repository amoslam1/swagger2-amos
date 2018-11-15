package org.amos.swagger2.controller.auto.permissions;

import java.util.List;

import org.amos.framework.request.PageRequest;
import org.amos.framework.tk.utils.TKConvertUtils;
import org.amos.framework.utils.ConvertUtils;
import org.amos.swagger2.model.auto.permissions.Role;
import org.amos.swagger2.service.auto.permissions.RoleAutoService;
import org.amos.framework.exception.bean.I18NErrorCode;
import org.amos.framework.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import org.amos.swagger2.controller.bean.request.auto.permissions.SaveRoleRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.UpdateRoleRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.DeleteRoleRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.GetByIdRoleRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.FindByRoleRequest;

import org.amos.framework.bean.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:32
 * 内容：RoleAutoController
 * ===============================
*/

@RestController
@RequestMapping("/role/auto")
public class RoleAutoController {

    @Autowired
    private RoleAutoService roleService;

	@PreAuthorize("hasAuthority('RoleAuto:save')")
    @PostMapping("/save")
    @ResponseBody
    public Boolean save(SaveRoleRequest request) {
        
        Role obj = ConvertUtils.convertObject(request, Role.class);
        roleService.save(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('RoleAuto:delete')")
    @PostMapping("/delete")
    @ResponseBody
    public Boolean delete(DeleteRoleRequest request) {
    	
        roleService.deleteById(request.getId());
        
        return true;
    }

	@PreAuthorize("hasAuthority('RoleAuto:update')")
    @PostMapping("/update")
    @ResponseBody
    public Boolean update(UpdateRoleRequest request) {
        
        Role obj = ConvertUtils.convertObject(request, Role.class);
        roleService.update(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('RoleAuto:getById')")
    @PostMapping("/getById")
    @ResponseBody
    public Role getById(GetByIdRoleRequest request) {
    	
        Role role = roleService.getById(request.getId());
        return role;
    }
  
  	@PreAuthorize("hasAuthority('RoleAuto:findAll')")  
    @PostMapping("/findAll")
    @ResponseBody
    public List<Role> findAll() {
    	
        List<Role> list = roleService.findAll();
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
   
  	@PreAuthorize("hasAuthority('RoleAuto:getByRole')")
    @PostMapping("/getByRole")
    @ResponseBody
    public Role getByRole(FindByRoleRequest request) throws Exception {
    	
    	Example example = new Example(Role.class);
    	
    	TKConvertUtils.convertObject(example, request);
    	
    	Role obj = roleService.getByExample(example);
    	if(null == obj){
    		
    		throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
    	}
        return obj;
    }
  
    @PreAuthorize("hasAuthority('RoleAuto:findByRole')")  
    @PostMapping("/findByRole")
    @ResponseBody
    public List<Role> findByRole(FindByRoleRequest request) throws Exception {
    	
    	Condition condition = new Condition(Role.class);
    	
    	TKConvertUtils.convertObject(condition, request);

        List<Role> list = roleService.findByCondition(condition);
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
  
    @PreAuthorize("hasAuthority('RoleAuto:findRoleByPage')")   
    @PostMapping("/findRoleByPage")
    @ResponseBody
    public Page<Role> findRoleByPage(PageRequest<FindByRoleRequest> request) throws Exception {
    	
    	Page<Role> page = new Page<Role>(request.getCurrentPage(),request.getPageSize());
    	
    	Condition condition = new Condition(Role.class);
    	
    	FindByRoleRequest byRequest = request.getRequest();
    	
    	TKConvertUtils.convertObject(condition, byRequest);

    	PageHelper.startPage(request.getCurrentPage(), page.getPageSize());
        List<Role> list = roleService.findByCondition(condition);
        
        PageInfo<Role> pageInfo = new PageInfo<Role>(list);
        
        page.setDatas(list);
        page.setTotalRecord(Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        return page;
    }
}
