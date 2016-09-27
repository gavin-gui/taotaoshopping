package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.util.ExceptionUtil;
import com.taotao.common.util.TaotaoResult;
import com.taotao.rest.service.ContentService;

/**
 * 内容Controller
 * @author gui
 *
 */
@Controller
@RequestMapping("/rest/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/list/{categoryId}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable("categoryId")Long categoryId){
		try {
			TaotaoResult result = contentService.getContentList(categoryId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	
}
