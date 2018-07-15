package com.apache.shiro;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.yongchen.dao.UserDao;

public class CustomRealm extends AuthorizingRealm {

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//从主体传过来的认证信息获取用户名
		String userName = (String) token.getPrincipal();
		//根据用户名，从数据库中获取密码
		String password = getPassWordByUserName(userName);
		//
		if (password == null)
		{
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = 
				new SimpleAuthenticationInfo(userName, password, "customer");
		
		return authenticationInfo;
	}

	public static void main(String[] args) {
		
		getPassWordByUserName("zhangsan");
	}
	
	
	
	private static String getPassWordByUserName(String userName)
	{
		SqlSessionFactory sessionFactory = MybatisTest.getInstance().getSqlSessionFactory();
		UserDao user = sessionFactory.openSession().getMapper(UserDao.class);
		
		String password = user.getPasswordByUerName(userName);
		System.out.println(password);
		return password;
	}
}
