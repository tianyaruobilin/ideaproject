package com.springbootmq.springbootmq;

import com.springbootmq.springbootmq.config.HelloSender;
import com.springbootmq.springbootmq.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootmqApplicationTests {

   @Autowired
    private HelloSender helloSender;

 /* @Autowired

    @Test
    public void contextLoads() {
    }

    @Test//这是一对一发送消息
    public void hello() throws Exception{
        helloSender.send();
    }

    @Test//一对多
    public void oneTomany() throws Exception{
        for (int i = 0; i < 100; i++) {
            helloSender.send(i);
        }
    }

    @Test//多对多
    public void manyTomany() throws Exception{
        for (int i = 0; i < 100; i++) {
            helloSender.send(i);
            helloSender.sendTwice(i);
        }
    }

    @Test
    public void objectSendReciver() throws Exception{
        Book book1=new Book(1,"jpm");
        Book book2=new Book(2, "xxj");
        helloSender.sendObject(book1);
        helloSender.sendObject(book2);
    }*/

 @Test
    public void topicExchange() throws Exception{
        helloSender.send1();
        helloSender.send2();
    }

    @Test
    public void fanout() throws Exception{
        helloSender.send3();
    }
}
