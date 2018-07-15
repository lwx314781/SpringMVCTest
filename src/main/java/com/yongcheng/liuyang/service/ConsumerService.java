package com.yongcheng.liuyang.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 结合spring实现消息的消费
 * 
 * @author Administrator
 *
 */
//@Service
public class ConsumerService
{
    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
    
    /**
     * 接收消息
     * @param destination  目标队列
     * @return 消息体
     */
    public TextMessage reciew(Destination destination){
        
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        
        try
        {
            System.out.println("从队列" + destination.toString() + "收到了消息:" + textMessage.getText());
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
        return textMessage;
    }
}
