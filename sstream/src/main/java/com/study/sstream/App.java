package com.study.sstream;


import com.study.sstream.staticproxy.IHello;
import com.study.sstream.staticproxy.ProxyHello;
import com.study.sstream.staticproxy.impl.Hello;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
        //测试Stream 多线程
//        long parallel = StreamOperate.parallel(20);
//        System.out.println(parallel);

        //测试stream 操作
//        Lambda.testForeach();

        //测试Stream 去重
//        Lambda.testStreamDuplicates();

        // 测试 classLoader
//        ClassLoaderTest.classLoadertest();

//        InputStream resourceAsStream = App.class.getClassLoader().getResourceAsStream("fruit.properties");
//        byte[] bytes=new byte[resourceAsStream.available()];
//        resourceAsStream.read(bytes);
//        System.out.println(bytes.toString());
//        Properties properties=new Properties();
//        properties.load(resourceAsStream);
//        System.out.println(properties.get("apple"));

        //简单的静态代理
        IHello iHello = new ProxyHello(new Hello());    //如果需要使用日志，就使用代理类
        //IHello iHello=new Hello();//如果不需要使用日志则使用目标类
        iHello.sayHello("明天");
    }
}
