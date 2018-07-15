package com.yongchen.thread;

import org.apache.ibatis.session.SqlSessionFactory;

import com.apache.shiro.MybatisTest;

/**
 * 多线程下测试单例
 * 
 * @author 刘洋
 *
 */
public class TestSingleton implements Runnable {

	public static void main(String[] args) {
		TestSingleton singleton0 = new TestSingleton();
		TestSingleton singleton1 = new TestSingleton();
		TestSingleton singleton2 = new TestSingleton();
		TestSingleton singleton3 = new TestSingleton();
		TestSingleton singleton4 = new TestSingleton();
		Thread t1 = new Thread(singleton0,"线程1");
		Thread t2 = new Thread(singleton1,"线程2");
		Thread t3 = new Thread(singleton2,"线程3");
		Thread t4 = new Thread(singleton3,"线程4");
		Thread t5 = new Thread(singleton4,"线程5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	
	@Override
	public void run() {
		
		MybatisTest test = MybatisTest.getInstance();
		System.out.println(test.toString());
		SqlSessionFactory sqlSessionFactory=test.getSqlSessionFactory();
		System.out.println(Thread.currentThread().getName() + sqlSessionFactory.toString());
	}

}
