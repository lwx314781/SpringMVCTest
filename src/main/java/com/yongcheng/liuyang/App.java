package com.yongcheng.liuyang;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.yongcheng.liuyang.utils.MessageUtil;

public class App 
{
    public static void main(String[] args) 
    {
        //手动初始化application
        String[] config = {"classpath*:spring-mvc.xml"};
        MessageUtil util = new MessageUtil();
        util.setApplicationContext(new FileSystemXmlApplicationContext(config));
        //获取对应的资源文件
        String str = util.getMessage("date",new Object[]{0});
        System.out.println(str);
    }
}
