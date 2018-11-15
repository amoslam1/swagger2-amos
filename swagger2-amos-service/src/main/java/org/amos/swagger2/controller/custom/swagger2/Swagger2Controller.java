package org.amos.swagger2.controller.custom.swagger2;

import org.amos.swagger2.controller.bean.request.custom.swagger2.CollectApiDocsRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/swagger2")
public class Swagger2Controller {

	@PostMapping("/collectApiDocs")
	@ResponseBody
	public Boolean collectApiDocs(@RequestBody CollectApiDocsRequest request){
		
		System.out.println(JSONObject.toJSONString(request));
		return true;
	}
}
