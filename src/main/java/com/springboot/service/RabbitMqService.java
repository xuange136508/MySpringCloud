package com.springboot.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    @RabbitListener(queues = "queue1")
    public void receive(Object obj){
        System.out.println("收到消息："+obj);
    }

    @RabbitListener(queues = "queue2")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
