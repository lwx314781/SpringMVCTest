package com.apache.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.map.ext.CoreXMLDeserializers.DurationDeserializer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.internal.CustomizerRegistry;

import com.alibaba.druid.pool.DruidDataSource;

public class ShiroTests {

	//建立数据源
    static DruidDataSource dataSource = new DruidDataSource();
    
    static 
    {
    	dataSource.setUrl("jdbc:mysql://localhost:3306/yongchen");
    	dataSource.setUsername("root");
    	dataSource.setPassword("liuyang");
    }
	
	SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
	
	@Before
	public void addUser()
	{
		simpleAccountRealm.addAccount("liuyang", "123456", "admin");
		simpleAccountRealm.addAccount("zhangsan", "123456","admin1");
	}
	
	
	@Test
	public void testAuthentication()
	{
		//自定义realm
		CustomRealm realm = new CustomRealm();
		//构建主题环境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(realm);
		
 		//主题提交认证
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
		subject.login(token);
		
		System.out.println(subject.isAuthenticated());
		subject.checkRole("admin1");
		
//		subject.logout();
		
//		System.out.println(subject.isAuthenticated());
	}
	
	
	/**
	 *创建jdbcrealm 
	 *
	 */
//	@Test
	public void jdbcTestAuthentication()
	{
		
		//创建JDBCRealm
	    JdbcRealm jdbcRealm = new JdbcRealm();
		//设置数据源
       	jdbcRealm.setDataSource(dataSource);
       	//开启权限验证
       	jdbcRealm.setPermissionsLookupEnabled(true);
       	
       	String sql = "select password from user_test where user_name = ?";
       	jdbcRealm.setAuthenticationQuery(sql);
		
		//构建主题环境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(jdbcRealm);
		
 		//主题提交认证
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("xiaoming", "654321");
		subject.login(token);
		
		System.out.println(subject.isAuthenticated());
		subject.checkRoles("ordinary");		
//		subject.logout();
		
		System.out.println(subject.isAuthenticated());
	}
	
}
