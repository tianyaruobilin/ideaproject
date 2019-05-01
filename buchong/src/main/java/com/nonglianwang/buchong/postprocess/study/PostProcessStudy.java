package com.nonglianwang.buchong.postprocess.study;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessStudy implements BeanPostProcessor {

    /**
     * 初始化之前
     * @param bean 实现该后置类的bean
     * @param beanName  实现该后之类的类名
     * @return  该bean
     * @throws BeansException 找不到该类
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器开始调用了");

        System.out.println("bean = [" + bean + "], beanName = [" + beanName + "]");
        try {
            Thread.sleep(1000); //休眠一秒，模拟调用
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return bean;
    }

    /**
     * 初始化之后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器调用结束了");

        System.out.println("bean = [" + bean + "], beanName = [" + beanName + "]");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return bean;
    }
}
