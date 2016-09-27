package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.util.HttpClientUtil;
import com.taotao.common.util.JsonUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.portal.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	private static Logger log = Logger.getLogger(ContentServiceImpl.class);
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getContentList() {
		log.info("REST_BASE_URL:"+REST_BASE_URL+",REST_INDEX_AD_URL:"+REST_INDEX_AD_URL);
		//调用服务层服务
		try {
			String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
			log.info("调用服务层服务result:"+result);
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
			List<TbContent> list = (List<TbContent>)taotaoResult.getData();
			List<Map> resultList = new ArrayList<>();
			for (TbContent tbContent : list) {
				Map map = new HashMap();
				map.put("src", tbContent.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", tbContent.getPic2());
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", tbContent.getUrl());
				map.put("alt", tbContent.getSubTitle());
				resultList.add(map);
			}
			return JsonUtils.objectToJson(resultList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
