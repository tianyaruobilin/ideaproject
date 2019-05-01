package com.bootmq.bootmq.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * 消息接收者
 */
@Component
public class Reciver {
    private CountDownLatch latch=new CountDownLatch(1);

    public void reciverMessage(String message){
        System.out.println("Reciver <"+message+">");
        latch.countDown();//暂停，等待其它线程运行
    }

    public CountDownLatch getLatch(){
        return latch;
    }
}
