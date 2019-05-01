package com.study.sstream.staticproxy.impl;

import com.study.sstream.staticproxy.IHello;

/**
 * 目标类代码
 */
public class Hello implements IHello {
    @Override
    public void sayHello(String string) {
        System.out.println("hello" + string);
    }
}
