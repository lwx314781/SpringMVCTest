package com.yongchen.dao;

import java.util.Set;

public interface UserDao {

	String getPasswordByUerName(String userName);
	
	
	Set<String> getRoleNameByUserName(String userName);
}
