package com.yongcheng.liuyang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yongcheng.liuyang.dao.UserMapper;
import com.yongcheng.liuyang.model.AccountInfo;
import com.yongcheng.liuyang.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Resource
	private UserMapper userDao;
	
	@Override
	public void registerUser(AccountInfo accountInfo) {
		
		//注册成功后将用户信息
		
	}

	@Override
	public String getAccountInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateUserIsLegal(String name) {
		
		return userDao.queryUserNameIsExists(name) == 0;
	}

}
