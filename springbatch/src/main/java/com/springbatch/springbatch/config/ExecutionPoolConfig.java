package com.springbatch.springbatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync    //开启线程池
public class ExecutionPoolConfig {

    @Bean(value = "myTaskExecutor")
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        //设置拒绝策略
//        ThreadPoolExecutor.CallerRunsPolicy   --由调用线程处理该任务
//        ThreadPoolExecutor.AbortPolicy        --丢弃任务并抛出RejectedExecutionException异常
//        ThreadPoolExecutor.DiscardOldestPolicy --丢弃队列最前面的任务，然后尝试从新执行任务（重复此过程）
//        ThreadPoolExecutor.DiscardPolicy      --丢弃被拒绝的任务
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(10);
        executor.setAwaitTerminationSeconds(60);
        executor.setThreadNamePrefix("MyAsync-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //设置所有任务执行完后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //加载
        executor.initialize();
        return executor;
    }
}
