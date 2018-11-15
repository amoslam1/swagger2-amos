package org.amos.swagger2.controller.auto.user;

import java.util.List;

import org.amos.framework.request.PageRequest;
import org.amos.framework.tk.utils.TKConvertUtils;
import org.amos.framework.utils.ConvertUtils;
import org.amos.swagger2.controller.bean.request.auto.user.DeleteUserRequest;
import org.amos.swagger2.controller.bean.request.auto.user.FindByUserRequest;
import org.amos.swagger2.controller.bean.request.auto.user.GetByIdUserRequest;
import org.amos.swagger2.controller.bean.request.auto.user.SaveUserRequest;
import org.amos.swagger2.controller.bean.request.auto.user.UpdateUserRequest;
import org.amos.swagger2.model.auto.user.User;
import org.amos.swagger2.service.auto.user.UserAutoService;
import org.amos.framework.exception.bean.I18NErrorCode;
import org.amos.framework.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.amos.framework.bean.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.amos.framework.annotation.Auto;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018-11-04 02:08:38
 * 内容：UserAutoController
 * ===============================
*/

@Api(tags = "鑷姩鐢熸垚_用户")
@Auto
@RestController
@RequestMapping("/user/auto")
public class UserAutoController {

    @Autowired
    private UserAutoService userService;

	@ApiOperation(value="鑷姩鐢熸垚_鏂板用户",notes="鑷姩鐢熸垚_鏂板用户")
    @PostMapping("/save")
    @ResponseBody
    public Boolean save(SaveUserRequest request) {
        
        User obj = ConvertUtils.convertObject(request, User.class);
        userService.save(obj);
        
        return true;
    }

	@ApiOperation(value="鑷姩鐢熸垚_鍒犻櫎用户",notes="鑷姩鐢熸垚_鍒犻櫎用户")
    @PostMapping("/delete")
    @ResponseBody
    public Boolean delete(DeleteUserRequest request) {
    	
        userService.deleteById(request.getId());
        
        return true;
    }

	@ApiOperation(value="鑷姩鐢熸垚_淇敼用户",notes="鑷姩鐢熸垚_淇敼用户")
    @PostMapping("/update")
    @ResponseBody
    public Boolean update(UpdateUserRequest request) {
        
        User obj = ConvertUtils.convertObject(request, User.class);
        userService.update(obj);
        
        return true;
    }

	@ApiOperation(value="鑷姩鐢熸垚_鏍规嵁涓婚敭鏌ヨ鍗曟潯用户璁板綍",notes="鑷姩鐢熸垚_鏍规嵁涓婚敭鏌ヨ鍗曟潯用户璁板綍")
    @PostMapping("/getById")
    @ResponseBody
    public User getById(GetByIdUserRequest request) {
    	
        User user = userService.getById(request.getId());
        return user;
    }
    
	@ApiOperation(value="鑷姩鐢熸垚_鏌ヨ用户鎵�鏈夎褰�",notes="鑷姩鐢熸垚_鏌ヨ用户鎵�鏈夎褰�")
    @PostMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
    	
        List<User> list = userService.findAll();
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
    
	@ApiOperation(value="鑷姩鐢熸垚_鏍规嵁用户淇℃伅鏌ヨ鍗曟潯用户璁板綍",notes="鑷姩鐢熸垚_鏍规嵁用户淇℃伅鏌ヨ鍗曟潯用户璁板綍")
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
    
	@ApiOperation(value="鑷姩鐢熸垚_鏍规嵁用户淇℃伅鏌ヨ澶氭潯用户璁板綍",notes="鑷姩鐢熸垚_鏍规嵁用户淇℃伅鏌ヨ澶氭潯用户璁板綍")
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
    
	@ApiOperation(value="鑷姩鐢熸垚_鏍规嵁用户淇℃伅鍒嗛〉鏌ヨ用户璁板綍",notes="鑷姩鐢熸垚_鏍规嵁用户淇℃伅鍒嗛〉鏌ヨ用户璁板綍")
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
