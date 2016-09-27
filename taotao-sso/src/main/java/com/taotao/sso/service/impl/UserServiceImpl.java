package com.taotao.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	
	/**
	 * 校验用户名/手机/邮箱是否存在
	 */
	public TaotaoResult checkData(String content, Integer type) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		
		if(1==type){//用户名校验
			criteria.andUsernameEqualTo(content);
		} else if (2==type){//手机校验
			criteria.andPhoneEqualTo(content);
		} else {//邮箱校验
			criteria.andEmailEqualTo(content);
		}
		List<TbUser> userList = userMapper.selectByExample(example);
		if(userList != null && userList.size()==1){
			return TaotaoResult.ok(false);
		}
		
		return TaotaoResult.ok(true);
	}

}
