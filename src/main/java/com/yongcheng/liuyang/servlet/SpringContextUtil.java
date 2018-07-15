package com.yongcheng.liuyang.servlet;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 手动初始化spring的容器
 * 
 * @author Administrator
 *
 */
public class SpringContextUtil implements ApplicationContextAware
{

    private static ApplicationContext context;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.context = applicationContext;
    }
    
    public static <T>T getBean(String name)
    {
        return (T) context.getBean(name);
    }

}
