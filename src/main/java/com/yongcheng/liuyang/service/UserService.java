package com.yongcheng.liuyang.service;

import com.yongcheng.liuyang.model.AccountInfo;

/**
 * 用户注册，登录服务接口
 * 
 * @author 刘洋
 */
public interface UserService 
{
    /**
     * 用户注册
     * 
     * @param accountInfo
     */
	public void registerUser(AccountInfo accountInfo);
     
	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param userId 用户账号
	 * @return 用户信息
	 */
	public String getAccountInfoByUserId(String userId);
    
}
