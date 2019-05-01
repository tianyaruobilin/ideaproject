package com.springbatch.springbatch.thread.asyn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Component
public class Hello {

    /**
     * 无返回值的异步调用
     * @param name
     */
    @Async
    public void sayHi(String name){
        log.info(name+": hello world.");
    }

    @Async
    public ListenableFuture<String> sayHiAndReturn(String name){
        String resp=name+": hello world and return.";
        log.info(resp);
        return new AsyncResult<>(resp);
    }
}
