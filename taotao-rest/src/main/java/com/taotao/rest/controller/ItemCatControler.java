package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.util.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

@Controller
public class ItemCatControler {

	@Autowired
	ItemCatService itemCatService;
	
	@RequestMapping(value="/itemcat/list",produces={MediaType.TEXT_HTML_VALUE+";charset=utf-8;",MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public String getItemCatList(String callback){
		CatResult catResult = itemCatService.getItemCatList();
		String json = JsonUtils.objectToJson(catResult);
		String result = callback + "(" + json + ");";
		return result;
	}
	
	/*@RequestMapping("/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback){
		CatResult catResult = itemCatService.getItemCatList();
		MappingJacksonValue jacksonValue = new MappingJacksonValue(catResult);
		jacksonValue.setJsonpFunction(callback);
		return jacksonValue;
	}*/
	
}
