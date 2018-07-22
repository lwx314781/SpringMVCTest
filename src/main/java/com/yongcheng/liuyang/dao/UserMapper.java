package com.yongcheng.liuyang.dao;

import org.springframework.stereotype.Repository;

import com.yongcheng.liuyang.model.AccountInfo;

/**
 * 用户信息的增删改查mapper
 * 
 * @author 刘洋
 */
@Repository(value="userDao")
public interface UserMapper {
    
	 /**
     * 用户注册
     * 
     * @param user 当前用户信息
     */
    public void insertUserInfo(AccountInfo user);
	
    /**
     * 根据用户名Id获取对应的密码
     * 
     * @param userName
     * @return
     */
    public String queryPasswordByUserId(String userName);
    
    /**
     * 校验当前的用户是否存在
     * 
     * @param name
     * @return
     */
    public int queryUserNameIsExists(String name);
}
