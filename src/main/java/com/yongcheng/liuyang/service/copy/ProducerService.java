package com.yongcheng.liuyang.service.copy;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * 结合spring实现发布/订阅式的消息实现
 * 
 * 
 * @author Administrator
 *
 */
//@Service
public class ProducerService
{
    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
    
    /**
     * 发送消息
     * @param destination 目标队列
     * @param msg 消息
     */
    private void sendMessage(Destination destination,final String msg)
    {
        System.out.println(Thread.currentThread().getName() + 
                "向队列" + destination.toString() + "发送消息");
        jmsTemplate.send(destination, new MessageCreator()
        {
            @Override
            public Message createMessage(Session session) throws JMSException
            {
                return session.createTextMessage(msg);
            }
        });
    }
    
    /**
     * 发送消息
     * @param destination 目标队列
     * @param msg 消息
     */
    private void sendMessage(final String msg){
        //默认消息队列的名称
        String destinationName = jmsTemplate.getDefaultDestinationName();
        System.out.println(Thread.currentThread().getName() + "相队列"
                            + destinationName + "发送消息-------------->" + msg);
        
        jmsTemplate.send(destinationName, new MessageCreator()
        {
            @Override
            public Message createMessage(Session session) throws JMSException
            {
                return session.createTextMessage(msg);
            }
        });
    }
}
