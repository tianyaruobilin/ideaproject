package com.study.sstream.dynamicproxy;

import com.study.sstream.staticproxy.IHello;
import com.study.sstream.staticproxy.impl.Hello;
import org.junit.Test;

public class DynamicProxyHelloTest extends DynamicProxyHello{

    @Test
    public void test(){
        IHello hello = (IHello) bind(new Hello());//如果我们需要日志功能，则使用代理类
        hello.sayHello("明天");
    };
}