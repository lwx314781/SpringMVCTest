package com.yongcheng.liuyang.dao;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.yongcheng.liuyang.model.User;

@Repository(value="userMapper")
public interface UserMapper {
    
    public User queryUserByName(String userName);
    
    public Set<String> queryRolesByName(String userName);
}
