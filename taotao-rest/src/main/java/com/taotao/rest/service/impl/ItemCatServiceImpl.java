package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	TbItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCatList() {
		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0L));
		return catResult;
	}

	/**
	 * 查询分类列表
	 */
	public List<?> getCatList(Long parentId) {
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<Object> result = new ArrayList<Object>();
		List<TbItemCat> itemCatList =  itemCatMapper.selectByExample(example);
		int count = 0;
		for(TbItemCat itemCat : itemCatList){
			
			if(itemCat.getIsParent()){
				
				CatNode node = new CatNode();
				if(itemCat.getParentId()==0){
					node.setName("<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
				} else {
					node.setName(itemCat.getName());
				}
				node.setUrl("/products/"+itemCat.getId()+".html");
				node.setItem(getCatList(itemCat.getId()));
				result.add(node);
				count++;
				if(itemCat.getParentId()==0 && count >=14){
					break;
				}
			} else {
				result.add("/products/"+itemCat.getId()+".html|"+itemCat.getName());
			}
			
		}
		
		return result;
	}

}
