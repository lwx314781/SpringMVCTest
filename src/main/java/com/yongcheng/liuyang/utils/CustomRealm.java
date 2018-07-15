package com.yongcheng.liuyang.utils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component
public class CustomRealm extends AuthorizingRealm
{

	
	
	/**
	 * 主要用于认证，从数据库查询用户信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * shrio实现用户登录验证
	 * 
	 * 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//从主体传过来的认证信息获取用户名
		String userName = (String) token.getPrincipal();
		//根据用户名，从数据库中获取密码
		String password = "";
		//
		if (password == null)
		{
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = 
				new SimpleAuthenticationInfo(userName, password, "customer");
		
		return authenticationInfo;
		
	}
    
}
