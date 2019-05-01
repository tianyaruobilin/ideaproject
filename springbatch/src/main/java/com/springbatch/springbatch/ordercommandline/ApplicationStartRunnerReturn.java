package com.springbatch.springbatch.ordercommandline;

import com.springbatch.springbatch.thread.asyn.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class ApplicationStartRunnerReturn implements CommandLineRunner {

    @Autowired
    Hello hello;

    @Override
    public void run(String... args) throws Exception {
        ListenableFuture<String> stringListenableFuture = hello.sayHiAndReturn("asyncAndReturn" + Thread.currentThread().getName());
        String s = stringListenableFuture.get();
        System.out.println(s);

    }
}
