package com.springbootmq.springbootmq.config;

import com.springbootmq.springbootmq.entity.Book;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Date;

/**
 * 发送者
 * rabbitTemplate是springboot提供的默认实现(所以可以直接装配)
 */
@Configuration
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /*public void send(){
        String context="hello"+new Date();
        System.out.println("Sender:"+context);
        this.rabbitTemplate.convertAndSend("hello", context);//转化发送//将内容转化为hello名字的消息队列
    }


*//*    public void send(int i){
        String context ="hello" + i;
        System.out.println("Sender:"+context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }*//*
    public void sendTwice(int i){
        String context ="hello" + i;
        System.out.println("Sender:"+context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    public void sendObject(Book book){

        System.out.println("sendObject:"+book.toString());
        this.rabbitTemplate.convertAndSend("ttt", book);
    }*/

    public void send1(){
        String context="hi,i am message 1";
        System.out.println("sender:"+context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send2(){
        String context="hi,i am message 2";
        System.out.println("sender:"+context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }

    public  void send3(){
        String context="hi,fanout msg";
        System.out.println("Sender:"+context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", context);
    }
}
