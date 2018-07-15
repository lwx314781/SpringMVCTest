package com.yongcheng.liuyang.filter;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 接受消息的过滤器
 * 
 * @author Administrator
 *
 */
public class QueueMessageListener implements MessageListener
{

    @Override
    public void onMessage(Message message)
    {
        TextMessage text = (TextMessage)message;
        try
        {
            System.out.println("QueueMessageListener监听到了文本消息：\t"
                    + text.getText());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
