package com.springbootmq.springbootmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class ReciverTopAll {
    @RabbitHandler
    public void stringHandler(String name){
        System.out.println("hello, i am  ReciverTopAll , i get "+name);
    }
}
