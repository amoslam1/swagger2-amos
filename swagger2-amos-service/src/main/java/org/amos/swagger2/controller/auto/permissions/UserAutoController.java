package org.amos.swagger2.controller.auto.permissions;

import java.util.List;

import org.amos.framework.request.PageRequest;
import org.amos.framework.tk.utils.TKConvertUtils;
import org.amos.framework.utils.ConvertUtils;
import org.amos.swagger2.model.auto.permissions.User;
import org.amos.swagger2.service.auto.permissions.UserAutoService;
import org.amos.framework.exception.bean.I18NErrorCode;
import org.amos.framework.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import org.amos.swagger2.controller.bean.request.auto.permissions.SaveUserRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.UpdateUserRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.DeleteUserRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.GetByIdUserRequest;
import org.amos.swagger2.controller.bean.request.auto.permissions.FindByUserRequest;

import org.amos.framework.bean.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-15 20:01:32
 * 内容：UserAutoController
 * ===============================
*/

@RestController
@RequestMapping("/user/auto")
public class UserAutoController {

    @Autowired
    private UserAutoService userService;

	@PreAuthorize("hasAuthority('UserAuto:save')")
    @PostMapping("/save")
    @ResponseBody
    public Boolean save(SaveUserRequest request) {
        
        User obj = ConvertUtils.convertObject(request, User.class);
        userService.save(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('UserAuto:delete')")
    @PostMapping("/delete")
    @ResponseBody
    public Boolean delete(DeleteUserRequest request) {
    	
        userService.deleteById(request.getId());
        
        return true;
    }

	@PreAuthorize("hasAuthority('UserAuto:update')")
    @PostMapping("/update")
    @ResponseBody
    public Boolean update(UpdateUserRequest request) {
        
        User obj = ConvertUtils.convertObject(request, User.class);
        userService.update(obj);
        
        return true;
    }

	@PreAuthorize("hasAuthority('UserAuto:getById')")
    @PostMapping("/getById")
    @ResponseBody
    public User getById(GetByIdUserRequest request) {
    	
        User user = userService.getById(request.getId());
        return user;
    }
  
  	@PreAuthorize("hasAuthority('UserAuto:findAll')")  
    @PostMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
    	
        List<User> list = userService.findAll();
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
   
  	@PreAuthorize("hasAuthority('UserAuto:getByUser')")
    @PostMapping("/getByUser")
    @ResponseBody
    public User getByUser(FindByUserRequest request) throws Exception {
    	
    	Example example = new Example(User.class);
    	
    	TKConvertUtils.convertObject(example, request);
    	
    	User obj = userService.getByExample(example);
    	if(null == obj){
    		
    		throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
    	}
        return obj;
    }
  
    @PreAuthorize("hasAuthority('UserAuto:findByUser')")  
    @PostMapping("/findByUser")
    @ResponseBody
    public List<User> findByUser(FindByUserRequest request) throws Exception {
    	
    	Condition condition = new Condition(User.class);
    	
    	TKConvertUtils.convertObject(condition, request);

        List<User> list = userService.findByCondition(condition);
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
  
    @PreAuthorize("hasAuthority('UserAuto:findUserByPage')")   
    @PostMapping("/findUserByPage")
    @ResponseBody
    public Page<User> findUserByPage(PageRequest<FindByUserRequest> request) throws Exception {
    	
    	Page<User> page = new Page<User>(request.getCurrentPage(),request.getPageSize());
    	
    	Condition condition = new Condition(User.class);
    	
    	FindByUserRequest byRequest = request.getRequest();
    	
    	TKConvertUtils.convertObject(condition, byRequest);

    	PageHelper.startPage(request.getCurrentPage(), page.getPageSize());
        List<User> list = userService.findByCondition(condition);
        
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        
        page.setDatas(list);
        page.setTotalRecord(Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        return page;
    }
}
