package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCatService;

@Service
public class ContentCatServiceImpl implements ContentCatService {

	@Autowired
	TbContentCategoryMapper contentCategoryMapper;
	
	public List<EUTreeNode> getContentCatList(Long parentId) {
		
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		
		List<TbContentCategory> contnetCatList = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<EUTreeNode>();
		for (TbContentCategory tbContentCategory : contnetCatList) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		
		return resultList;
	}

	public TaotaoResult insertContentCategory(Long parentId, String name) {
		TbContentCategory record = new TbContentCategory();
		record.setParentId(parentId);
		record.setName(name);
		record.setStatus(1);
		record.setSortOrder(1);
		record.setIsParent(false);
		record.setCreated(new Date());
		record.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(record);
		
		//更新父节点
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!contentCategory.getIsParent()){
			contentCategory.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(contentCategory);
		}
		
		return TaotaoResult.ok(record);
	}

}
