package com.taotao.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.TbItemService;

@Service("itemService")
public class TbItemServiceImpl implements TbItemService {

	private static Logger log = Logger.getLogger(TbItemServiceImpl.class);
	
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem getItemById(Long itemId) {
		log.info("getItemById itemId:"+itemId);
		return tbItemMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public EUDataGridResult getItemList(int page, int row) {
		TbItemExample example = new TbItemExample();
		
		//分页处理
		PageHelper.startPage(page, row);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		EUDataGridResult result= new EUDataGridResult();
		result.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
