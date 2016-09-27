package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.util.TaotaoResult;

public interface ContentCatService {

	public List<EUTreeNode> getContentCatList(Long parentId);
	
	public TaotaoResult insertContentCategory(Long parentId,String name);
	
}
