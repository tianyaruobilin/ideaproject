package com.springbatch.springbatch.ordercommandline;

import com.springbatch.springbatch.thread.asyn.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
//@Order(value = 2)
public class ApplicationStartRunnerTwo implements CommandLineRunner {

    @Autowired
    Hello hello;

    @Async
    @Override
    public void run(String... args) throws Exception {
        hello.sayHi(Thread.currentThread().getName()+"TWO");
    }
}