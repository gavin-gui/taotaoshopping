package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface TbItemService {

	TbItem getItemById(Long itemId);
	
	EUDataGridResult getItemList(int page,int row);
}
