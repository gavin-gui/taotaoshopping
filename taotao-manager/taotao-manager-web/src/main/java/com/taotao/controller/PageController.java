package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 * @author gui
 *
 */
@Controller
public class PageController {

	/**
	 * 打开首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable("page")String page){
		return page;
	}
}
