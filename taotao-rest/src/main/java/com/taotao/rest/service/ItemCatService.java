package com.taotao.rest.service;

import java.util.List;

import com.taotao.rest.pojo.CatResult;

public interface ItemCatService {

	public CatResult getItemCatList();
	
	public List<?> getCatList(Long parentId);
}
