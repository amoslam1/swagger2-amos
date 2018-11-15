package org.amos.swagger2.controller.auto.permissions;

import java.util.List;

import org.amos.framework.request.PageRequest;
import org.amos.framework.tk.utils.TKConvertUtils;
import org.amos.framework.utils.ConvertUtils;
import org.amos.swagger2.model.auto.permissions.UserRoleRel;
import org.amos.swagger2.service.auto.permissions.UserRoleRelAutoService;
import org.amos.framework.exception.bean.I18NErrorCode;
import org.amos.framework.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import org.amos.swagger2.controller.bean.request.auto.permissions.SaveUserRoleRelRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.UpdateUserRoleRelRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.DeleteUserRoleRelRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.GetByIdUserRoleRelRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.FindByUserRoleRelRequest;

import org.amos.framework.bean.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:32
 * 内容：UserRoleRelAutoController
 * ===============================
*/

@RestController
@RequestMapping("/userRoleRel/auto")
public class UserRoleRelAutoController {

    @Autowired
    private UserRoleRelAutoService userRoleRelService;

	@PreAuthorize("hasAuthority('UserRoleRelAuto:save')")
    @PostMapping("/save")
    @ResponseBody
    public Boolean save(SaveUserRoleRelRequest request) {
        
        UserRoleRel obj = ConvertUtils.convertObject(request, UserRoleRel.class);
        userRoleRelService.save(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('UserRoleRelAuto:delete')")
    @PostMapping("/delete")
    @ResponseBody
    public Boolean delete(DeleteUserRoleRelRequest request) {
    	
        userRoleRelService.deleteById(request.getId());
        
        return true;
    }

	@PreAuthorize("hasAuthority('UserRoleRelAuto:update')")
    @PostMapping("/update")
    @ResponseBody
    public Boolean update(UpdateUserRoleRelRequest request) {
        
        UserRoleRel obj = ConvertUtils.convertObject(request, UserRoleRel.class);
        userRoleRelService.update(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('UserRoleRelAuto:getById')")
    @PostMapping("/getById")
    @ResponseBody
    public UserRoleRel getById(GetByIdUserRoleRelRequest request) {
    	
        UserRoleRel userRoleRel = userRoleRelService.getById(request.getId());
        return userRoleRel;
    }
  
  	@PreAuthorize("hasAuthority('UserRoleRelAuto:findAll')")  
    @PostMapping("/findAll")
    @ResponseBody
    public List<UserRoleRel> findAll() {
    	
        List<UserRoleRel> list = userRoleRelService.findAll();
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
   
  	@PreAuthorize("hasAuthority('UserRoleRelAuto:getByUserRoleRel')")
    @PostMapping("/getByUserRoleRel")
    @ResponseBody
    public UserRoleRel getByUserRoleRel(FindByUserRoleRelRequest request) throws Exception {
    	
    	Example example = new Example(UserRoleRel.class);
    	
    	TKConvertUtils.convertObject(example, request);
    	
    	UserRoleRel obj = userRoleRelService.getByExample(example);
    	if(null == obj){
    		
    		throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
    	}
        return obj;
    }
  
    @PreAuthorize("hasAuthority('UserRoleRelAuto:findByUserRoleRel')")  
    @PostMapping("/findByUserRoleRel")
    @ResponseBody
    public List<UserRoleRel> findByUserRoleRel(FindByUserRoleRelRequest request) throws Exception {
    	
    	Condition condition = new Condition(UserRoleRel.class);
    	
    	TKConvertUtils.convertObject(condition, request);

        List<UserRoleRel> list = userRoleRelService.findByCondition(condition);
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
  
    @PreAuthorize("hasAuthority('UserRoleRelAuto:findUserRoleRelByPage')")   
    @PostMapping("/findUserRoleRelByPage")
    @ResponseBody
    public Page<UserRoleRel> findUserRoleRelByPage(PageRequest<FindByUserRoleRelRequest> request) throws Exception {
    	
    	Page<UserRoleRel> page = new Page<UserRoleRel>(request.getCurrentPage(),request.getPageSize());
    	
    	Condition condition = new Condition(UserRoleRel.class);
    	
    	FindByUserRoleRelRequest byRequest = request.getRequest();
    	
    	TKConvertUtils.convertObject(condition, byRequest);

    	PageHelper.startPage(request.getCurrentPage(), page.getPageSize());
        List<UserRoleRel> list = userRoleRelService.findByCondition(condition);
        
        PageInfo<UserRoleRel> pageInfo = new PageInfo<UserRoleRel>(list);
        
        page.setDatas(list);
        page.setTotalRecord(Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        return page;
    }
}
