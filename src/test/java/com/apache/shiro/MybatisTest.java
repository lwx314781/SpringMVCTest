package com.apache.shiro;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 测试mybatis
 * 
 * @author Administrator
 *
 */
public class MybatisTest {

	private SqlSessionFactory sqlSessionFactory = null;
	
	private static MybatisTest singleton = null;
	
	private MybatisTest()
	{
		
	}
	
	//单例模式  
	public static MybatisTest getInstance()
	{
		if (singleton == null)
		{
			singleton = new MybatisTest();
		}
		
		return singleton;
	}
	
	
	public SqlSessionFactory getSqlSessionFactory()
	{
			if (sqlSessionFactory == null)
			{
				InputStream inputStream = null;
				
				try {
					inputStream = Resources.getResourceAsStream("mybatis-conifg.xml");
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		return sqlSessionFactory;
	}
	
}
