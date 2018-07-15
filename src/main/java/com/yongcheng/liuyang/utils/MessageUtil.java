package com.yongcheng.liuyang.utils;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;

/**
 * 
 * 定义一个messageSource
 * 
 * @author Administrator
 */
public class MessageUtil implements ApplicationContextAware
{
    private static MessageSource messageSource;
    
    private ApplicationContext context;
    
    //初始化资源加载器
    public void init()  
    {  
        if (messageSource == null)  
        {  
            synchronized (MessageUtil.class)  
            {  
                messageSource = (MessageSource) context.getBean("messageSource");  
            }  
        }  
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException 
    {
        this.context = applicationContext;
    }
    
    public String getMessage(String id,Object[] param)
    {
        init();
        return messageSource.getMessage(id, param, Locale.getDefault());
    }
}
