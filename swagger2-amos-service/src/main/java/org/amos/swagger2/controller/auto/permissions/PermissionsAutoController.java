package org.amos.swagger2.controller.auto.permissions;

import java.util.List;

import org.amos.framework.request.PageRequest;
import org.amos.framework.tk.utils.TKConvertUtils;
import org.amos.framework.utils.ConvertUtils;
import org.amos.swagger2.model.auto.permissions.Permissions;
import org.amos.swagger2.service.auto.permissions.PermissionsAutoService;
import org.amos.framework.exception.bean.I18NErrorCode;
import org.amos.framework.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import org.amos.swagger2.controller.bean.request.auto.permissions.SavePermissionsRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.UpdatePermissionsRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.DeletePermissionsRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.GetByIdPermissionsRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.FindByPermissionsRequest;

import org.amos.framework.bean.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:32
 * 内容：PermissionsAutoController
 * ===============================
*/

@RestController
@RequestMapping("/permissions/auto")
public class PermissionsAutoController {

    @Autowired
    private PermissionsAutoService permissionsService;

	@PreAuthorize("hasAuthority('PermissionsAuto:save')")
    @PostMapping("/save")
    @ResponseBody
    public Boolean save(SavePermissionsRequest request) {
        
        Permissions obj = ConvertUtils.convertObject(request, Permissions.class);
        permissionsService.save(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('PermissionsAuto:delete')")
    @PostMapping("/delete")
    @ResponseBody
    public Boolean delete(DeletePermissionsRequest request) {
    	
        permissionsService.deleteById(request.getId());
        
        return true;
    }

	@PreAuthorize("hasAuthority('PermissionsAuto:update')")
    @PostMapping("/update")
    @ResponseBody
    public Boolean update(UpdatePermissionsRequest request) {
        
        Permissions obj = ConvertUtils.convertObject(request, Permissions.class);
        permissionsService.update(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('PermissionsAuto:getById')")
    @PostMapping("/getById")
    @ResponseBody
    public Permissions getById(GetByIdPermissionsRequest request) {
    	
        Permissions permissions = permissionsService.getById(request.getId());
        return permissions;
    }
  
  	@PreAuthorize("hasAuthority('PermissionsAuto:findAll')")  
    @PostMapping("/findAll")
    @ResponseBody
    public List<Permissions> findAll() {
    	
        List<Permissions> list = permissionsService.findAll();
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
   
  	@PreAuthorize("hasAuthority('PermissionsAuto:getByPermissions')")
    @PostMapping("/getByPermissions")
    @ResponseBody
    public Permissions getByPermissions(FindByPermissionsRequest request) throws Exception {
    	
    	Example example = new Example(Permissions.class);
    	
    	TKConvertUtils.convertObject(example, request);
    	
    	Permissions obj = permissionsService.getByExample(example);
    	if(null == obj){
    		
    		throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
    	}
        return obj;
    }
  
    @PreAuthorize("hasAuthority('PermissionsAuto:findByPermissions')")  
    @PostMapping("/findByPermissions")
    @ResponseBody
    public List<Permissions> findByPermissions(FindByPermissionsRequest request) throws Exception {
    	
    	Condition condition = new Condition(Permissions.class);
    	
    	TKConvertUtils.convertObject(condition, request);

        List<Permissions> list = permissionsService.findByCondition(condition);
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
  
    @PreAuthorize("hasAuthority('PermissionsAuto:findPermissionsByPage')")   
    @PostMapping("/findPermissionsByPage")
    @ResponseBody
    public Page<Permissions> findPermissionsByPage(PageRequest<FindByPermissionsRequest> request) throws Exception {
    	
    	Page<Permissions> page = new Page<Permissions>(request.getCurrentPage(),request.getPageSize());
    	
    	Condition condition = new Condition(Permissions.class);
    	
    	FindByPermissionsRequest byRequest = request.getRequest();
    	
    	TKConvertUtils.convertObject(condition, byRequest);

    	PageHelper.startPage(request.getCurrentPage(), page.getPageSize());
        List<Permissions> list = permissionsService.findByCondition(condition);
        
        PageInfo<Permissions> pageInfo = new PageInfo<Permissions>(list);
        
        page.setDatas(list);
        page.setTotalRecord(Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        return page;
    }
}
