package com.springbatch.springbatch.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.*;
import com.springbatch.springbatch.guava.ConCallabe;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/con") //高并发 concurrently
public class ConController {

    @Autowired
    @Qualifier("myTaskExecutor")
    TaskExecutor taskExecutor;

    @GetMapping("/test1")
    public String test1() throws InterruptedException {
        //模拟产生10万条数据

        List<String> list=new ArrayList<>();
        List<String> list2=new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            list.add("test:" + i);
        }

        //每条线程处理的数据尺寸
        int size=250;
        //需要创建的线程的条数
        int count=list.size()/size;
        if (count * size != list.size()) {
            count++;
        }
        int countNum=0;
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
        while (countNum < list.size()) {
            countNum+=size;
            ConCallabe conCallabe=new ConCallabe();
            //截取list数据,分给不同线程处理
            conCallabe.setList(ImmutableList.copyOf(list.subList(countNum - size, countNum < list.size() ? countNum : list.size())));
            @SuppressWarnings("unchecked") ListenableFuture listenableFuture = listeningExecutorService.submit(conCallabe);
            Futures.addCallback(listenableFuture, new FutureCallback<List<String>>() {
                @Override
                public void onSuccess(@Nullable List<String> strings) {
                    countDownLatch.countDown();
                    list2.addAll(strings);
                }

                @Override
                public void onFailure(Throwable throwable) {
                    countDownLatch.countDown();
                    log.info("处理出错:",throwable);
                }
            },executorService);
        }
        countDownLatch.await(30, TimeUnit.MINUTES);
        log.info("符合条件返回数据的个数为:"+list2);
        log.info("回调函数:"+list2.toString());
        return "正在处理......";
    }
}
