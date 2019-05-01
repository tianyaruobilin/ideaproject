package com.study.sstream.staticproxy;

import java.util.Date;

public class ProxyHello implements IHello {

    private IHello iHello;

    public ProxyHello(IHello iHello){
        super();
        this.iHello=iHello;
    }

    @Override
    public void sayHello(String string) {
        System.out.println(new Date()+" say hello start ...");//添加特定的方法
        iHello.sayHello(string);
        System.out.println(new Date()+" say hello end ...");
    }
}
