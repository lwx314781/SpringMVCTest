package com.apache.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * shiro的基础测试
 * 
 * 
 * @author Administrator
 *
 */
public class Shiro {

	private static final Logger logger = LoggerFactory.getLogger(Shiro.class);
	
	public static void main(String[] args) {
		logger.info("this is my first shiro");
		//创建工厂类
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//创建securityManager
		SecurityManager securityManager = factory.getInstance();
		
		//主题提交成功
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("liuyang", "123456");
		subject.login(token);
		subject.checkRoles("admin");
		subject.checkPermissions("user:update","user:read");
		
		System.out.println("认证成功:" + subject.isAuthenticated());
	}
}
