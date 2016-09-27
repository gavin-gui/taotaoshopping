package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.TbItemCatService;

@Service("itemCatService")
public class TbItemCatServiceImpl implements TbItemCatService {
	private static Logger log = Logger.getLogger(TbItemCatServiceImpl.class);

	@Autowired
	TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<EUTreeNode> getItemCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		
		//根据parentId查询子节点
		criteria.andParentIdEqualTo(parentId);
		log.info("criteria:"+criteria);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		List<EUTreeNode> result = new ArrayList<EUTreeNode>();
		for(TbItemCat itemCat : list){
			EUTreeNode node = new EUTreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			node.setState(itemCat.getIsParent()?"closed":"open");
			result.add(node);
		}
		
		return result;
	}

}
