package ${basePackage}.controller.auto${model};

import java.util.List;

import org.amos.framework.request.PageRequest;
import org.amos.framework.tk.utils.TKConvertUtils;
import org.amos.framework.utils.ConvertUtils;
import ${basePackage}.model.auto${model}.${modelNameUpperCamel};
import ${basePackage}.service.auto${model}.${modelAutoNameUpperCamel}Service;
import org.amos.framework.exception.bean.I18NErrorCode;
import org.amos.framework.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ${saveInput};
import ${updateInput};
import ${deleteInput};
import ${getByIdInput};
import ${findByModelInput};

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
 * 作者：${author}
 * 时间：${date}
 * 内容：${modelAutoNameUpperCamel}Controller
 * ===============================
*/

@Api(tags = "${classRemarks}")
@Auto
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelAutoNameUpperCamel}Controller {

    @Autowired
    private ${modelAutoNameUpperCamel}Service ${modelNameLowerCamel}Service;

	@ApiOperation(value="${saveInputRemarks}",notes="${saveInputRemarks}")
    @PostMapping("/save")
    @ResponseBody
    public Boolean save(${saveInputClass} request) {
        
        ${modelNameUpperCamel} obj = ConvertUtils.convertObject(request, ${modelNameUpperCamel}.class);
        ${modelNameLowerCamel}Service.save(obj);
        
        return true;
    }

	@ApiOperation(value="${deleteInputRemarks}",notes="${deleteInputRemarks}")
    @PostMapping("/delete")
    @ResponseBody
    public Boolean delete(${deleteInputClass} request) {
    	
        ${modelNameLowerCamel}Service.deleteById(request.getId());
        
        return true;
    }

	@ApiOperation(value="${updateInputRemarks}",notes="${updateInputRemarks}")
    @PostMapping("/update")
    @ResponseBody
    public Boolean update(${updateInputClass} request) {
        
        ${modelNameUpperCamel} obj = ConvertUtils.convertObject(request, ${modelNameUpperCamel}.class);
        ${modelNameLowerCamel}Service.update(obj);
        
        return true;
    }

	@ApiOperation(value="${getByIdInputRemarks}",notes="${getByIdInputRemarks}")
    @PostMapping("/getById")
    @ResponseBody
    public ${modelNameUpperCamel} getById(${getByIdInputClass} request) {
    	
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.getById(request.getId());
        return ${modelNameLowerCamel};
    }
    
	@ApiOperation(value="${findAllInputRemarks}",notes="${findAllInputRemarks}")
    @PostMapping("/findAll")
    @ResponseBody
    public List<${modelNameUpperCamel}> findAll() {
    	
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
    
	@ApiOperation(value="${getByModelInputRemarks}",notes="${getByModelInputRemarks}")
    @PostMapping("/getBy${modelNameUpperCamel}")
    @ResponseBody
    public ${modelNameUpperCamel} getBy${modelNameUpperCamel}(${findByModelInputClass} request) throws Exception {
    	
    	Example example = new Example(${modelNameUpperCamel}.class);
    	
    	TKConvertUtils.convertObject(example, request);
    	
    	${modelNameUpperCamel} obj = ${modelNameLowerCamel}Service.getByExample(example);
    	if(null == obj){
    		
    		throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
    	}
        return obj;
    }
    
	@ApiOperation(value="${findByModelInputRemarks}",notes="${findByModelInputRemarks}")
    @PostMapping("/findBy${modelNameUpperCamel}")
    @ResponseBody
    public List<${modelNameUpperCamel}> findBy${modelNameUpperCamel}(${findByModelInputClass} request) throws Exception {
    	
    	Condition condition = new Condition(${modelNameUpperCamel}.class);
    	
    	TKConvertUtils.convertObject(condition, request);

        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(condition);
        
        if(list.isEmpty()){
        	
        	throw new BusinessException(I18NErrorCode.ERR_DATA_EMPTY_ERROR);
        }
        return list;
    }
    
	@ApiOperation(value="${findPageByModelInputRemarks}",notes="${findPageByModelInputRemarks}")
    @PostMapping("/find${modelNameUpperCamel}ByPage")
    @ResponseBody
    public Page<${modelNameUpperCamel}> find${modelNameUpperCamel}ByPage(PageRequest<${findByModelInputClass}> request) throws Exception {
    	
    	Page<${modelNameUpperCamel}> page = new Page<${modelNameUpperCamel}>(request.getCurrentPage(),request.getPageSize());
    	
    	Condition condition = new Condition(${modelNameUpperCamel}.class);
    	
    	${findByModelInputClass} byRequest = request.getRequest();
    	
    	TKConvertUtils.convertObject(condition, byRequest);

    	PageHelper.startPage(request.getCurrentPage(), page.getPageSize());
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(condition);
        
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<${modelNameUpperCamel}>(list);
        
        page.setDatas(list);
        page.setTotalRecord(Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        return page;
    }
}
