package com.springbootredis.springbootredis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.CountDownLatch;

public class Reciver {
    private static final Logger LOGGER= LoggerFactory.getLogger(Reciver.class);

    private CountDownLatch latch;//倒数锁，把自己放在最后执行

    @Autowired
    public Reciver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void reciverMessage(String message){
        LOGGER.info("Recived<"+message+">");
        latch.countDown();
    }


}
