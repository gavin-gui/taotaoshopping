package com.taotao.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.TbItemCatService;

@Controller
@RequestMapping("/item/cat")
public class TbItemCatController {
	private static Logger log = Logger.getLogger(TbItemCatController.class);
	@Autowired
	TbItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		log.info("parentId:"+parentId);
		List<EUTreeNode> list = itemCatService.getItemCatList(parentId);
		
		log.info("list:"+list);
		return list;
	}
}
