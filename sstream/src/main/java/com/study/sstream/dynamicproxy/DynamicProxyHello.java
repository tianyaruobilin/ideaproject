package com.study.sstream.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 动态代理类代码
 */
public class DynamicProxyHello implements InvocationHandler {

    private Object target;//需要代理的目标对象

    public Object bind(Object object){
        this.target=object;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dataFormat.format(new Date())+"JDK动态代理前");
        method.invoke(this.target, args);
        System.out.println(dataFormat.format(new Date())+"JDK动态代理后");
        return null;
    }

}
