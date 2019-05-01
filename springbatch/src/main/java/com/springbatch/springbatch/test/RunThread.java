package com.springbatch.springbatch.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class RunThread implements CommandLineRunner {

    @Autowired
    @Qualifier("myTaskExecutor")
    private TaskExecutor taskExecutor;

//    private CountDownLatch countDownLatch;

    public void test() {
        int count = 1000;//并发线程数量
        for (int i = 0; i < count; i++) {
            taskExecutor.execute(new RunThread().new Task());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        test();
    }

    /**
     * 内部线程任务类
     */
    class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "新的线程");
        }
    }

}