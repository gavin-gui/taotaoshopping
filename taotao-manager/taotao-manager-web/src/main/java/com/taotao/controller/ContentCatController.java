package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.util.TaotaoResult;
import com.taotao.service.ContentCatService;

/**
 * 内容分类
 * @author gui
 *
 */
@Controller
public class ContentCatController {

	@Autowired
	ContentCatService contentCatService;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		return contentCatService.getContentCatList(parentId);
	}
	
	@RequestMapping("/content/category/create")
	@ResponseBody
	public TaotaoResult insertContnetCategory(Long parentId,String name){
		
		return contentCatService.insertContentCategory(parentId, name);
	}
	
	@RequestMapping("/content/category/update")
	@ResponseBody
	public TaotaoResult updateContnetCategory(Long id,String name){
		
		return null;
	}
	
}
