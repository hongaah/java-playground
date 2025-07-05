package cn.itsource.springbootdemo.projects.ActiveMQ;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import jakarta.jms.Destination;

/**
 * 消息发送者
 */
@Service
public class MsgProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, String msg) {
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }
}
