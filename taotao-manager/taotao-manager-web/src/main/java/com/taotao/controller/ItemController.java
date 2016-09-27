package com.taotao.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.TbItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	private static Logger log = Logger.getLogger(ItemController.class);
	
	@Autowired
	private TbItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable("itemId") Long itemId){
		log.info("ItemController getItemById itemId:"+itemId);
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(int page,int rows){
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
}
