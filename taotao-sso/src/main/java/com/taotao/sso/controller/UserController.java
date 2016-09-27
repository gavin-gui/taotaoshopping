package com.taotao.sso.controller;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.util.TaotaoResult;
import com.taotao.sso.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public TaotaoResult checkData(@PathVariable("param")String content,@PathVariable("type")Integer type,String callback){
		
		//参数有效性校验
		if(StringUtils.isBlank(content)){
			return TaotaoResult.build(400, "校验内容不能为空");
		}
		
		if(type == null){
			return TaotaoResult.build(400, "校验内容类型不能为空");
		}
		if(Arrays.binarySearch(new int[]{1,2,3}, type) < 0){
			return TaotaoResult.build(400, "校验内容类型错误");
		}
		
		if(StringUtils.isBlank(callback)){
			
		}
		
		TaotaoResult checkData = userService.checkData(content, type);
		return checkData;
	}
	
}
