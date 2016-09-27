package com.taotao.portal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.util.TaotaoResult;
import com.taotao.portal.service.ContentService;

@Controller
public class IndexController {

	private static Logger log = Logger.getLogger(IndexController.class);
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("index")
	public String showIndex(Model model){
		String result = contentService.getContentList();
		log.info("首页加载信息："+result);
		model.addAttribute("ad1", result);
		return "index";
	}
	
	@RequestMapping(value="/post/test",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult testPostReq(){
		return TaotaoResult.ok();
	}
}
