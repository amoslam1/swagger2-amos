package org.amos.swagger2.controller.auto.permissions;

import java.util.List;

import org.amos.framework.request.PageRequest;
import org.amos.framework.tk.utils.TKConvertUtils;
import org.amos.framework.utils.ConvertUtils;
import org.amos.swagger2.model.auto.permissions.RolePermissionsRel;
import org.amos.swagger2.service.auto.permissions.RolePermissionsRelAutoService;
import org.amos.framework.exception.bean.I18NErrorCode;
import org.amos.framework.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import org.amos.swagger2.controller.bean.request.auto.permissions.SaveRolePermissionsRelRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.UpdateRolePermissionsRelRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.DeleteRolePermissionsRelRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.GetByIdRolePermissionsRelRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.FindByRolePermissionsRelRequest;

import org.amos.framework.bean.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:32
 * 内容：RolePermissionsRelAutoController
 * ===============================
*/

@RestController
@RequestMapping("/rolePermissionsRel/auto")
public class RolePermissionsRelAutoController {

    @Autowired
    private RolePermissionsRelAutoService rolePermissionsRelService;

	@PreAuthorize("hasAuthority('RolePermissionsRelAuto:save')")
    @PostMapping("/save")
    @ResponseBody
    public Boolean save(SaveRolePermissionsRelRequest request) {
        
        RolePermissionsRel obj = ConvertUtils.convertObject(request, RolePermissionsRel.class);
        rolePermissionsRelService.save(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('RolePermissionsRelAuto:delete')")
    @PostMapping("/delete")
    @ResponseBody
    public Boolean delete(DeleteRolePermissionsRelRequest request) {
    	
        rolePermissionsRelService.deleteById(request.getId());
        
        return true;
    }

	@PreAuthorize("hasAuthority('RolePermissionsRelAuto:update')")
    @PostMapping("/update")
    @ResponseBody
    public Boolean update(UpdateRolePermissionsRelRequest request) {
        
        RolePermissionsRel obj = ConvertUtils.convertObject(request, RolePermissionsRel.class);
        rolePermissionsRelService.update(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('RolePermissionsRelAuto:getById')")
    @PostMapping("/getById")
    @ResponseBody
    public RolePermissionsRel getById(GetByIdRolePermissionsRelRequest request) {
    	
        RolePermissionsRel rolePermissionsRel = rolePermissionsRelService.getById(request.getId());
        return rolePermissionsRel;
    }
  
  	@PreAuthorize("hasAuthority('RolePermissionsRelAuto:findAll')")  
    @PostMapping("/findAll")
    @ResponseBody
    public List<RolePermissionsRel> findAll() {
    	
        List<RolePermissionsRel> list = rolePermissionsRelService.findAll();
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
   
  	@PreAuthorize("hasAuthority('RolePermissionsRelAuto:getByRolePermissionsRel')")
    @PostMapping("/getByRolePermissionsRel")
    @ResponseBody
    public RolePermissionsRel getByRolePermissionsRel(FindByRolePermissionsRelRequest request) throws Exception {
    	
    	Example example = new Example(RolePermissionsRel.class);
    	
    	TKConvertUtils.convertObject(example, request);
    	
    	RolePermissionsRel obj = rolePermissionsRelService.getByExample(example);
    	if(null == obj){
    		
    		throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
    	}
        return obj;
    }
  
    @PreAuthorize("hasAuthority('RolePermissionsRelAuto:findByRolePermissionsRel')")  
    @PostMapping("/findByRolePermissionsRel")
    @ResponseBody
    public List<RolePermissionsRel> findByRolePermissionsRel(FindByRolePermissionsRelRequest request) throws Exception {
    	
    	Condition condition = new Condition(RolePermissionsRel.class);
    	
    	TKConvertUtils.convertObject(condition, request);

        List<RolePermissionsRel> list = rolePermissionsRelService.findByCondition(condition);
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
  
    @PreAuthorize("hasAuthority('RolePermissionsRelAuto:findRolePermissionsRelByPage')")   
    @PostMapping("/findRolePermissionsRelByPage")
    @ResponseBody
    public Page<RolePermissionsRel> findRolePermissionsRelByPage(PageRequest<FindByRolePermissionsRelRequest> request) throws Exception {
    	
    	Page<RolePermissionsRel> page = new Page<RolePermissionsRel>(request.getCurrentPage(),request.getPageSize());
    	
    	Condition condition = new Condition(RolePermissionsRel.class);
    	
    	FindByRolePermissionsRelRequest byRequest = request.getRequest();
    	
    	TKConvertUtils.convertObject(condition, byRequest);

    	PageHelper.startPage(request.getCurrentPage(), page.getPageSize());
        List<RolePermissionsRel> list = rolePermissionsRelService.findByCondition(condition);
        
        PageInfo<RolePermissionsRel> pageInfo = new PageInfo<RolePermissionsRel>(list);
        
        page.setDatas(list);
        page.setTotalRecord(Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        return page;
    }
}
