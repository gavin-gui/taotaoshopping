package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;

public interface TbItemCatService {

	public List<EUTreeNode> getItemCatList(long parentId);
}
