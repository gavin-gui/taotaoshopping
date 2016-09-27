package com.taotao.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.rest.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	TbContentMapper contentMapper;
	
	public TaotaoResult getContentList(Long categoryId) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> content = contentMapper.selectByExample(example);
		
		return TaotaoResult.ok(content);
	}

}
