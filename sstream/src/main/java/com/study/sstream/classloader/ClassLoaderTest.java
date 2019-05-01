package com.study.sstream.classloader;


import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void  classLoadertest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 自定义类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(fileName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        // 使用 ClassLoaderTest 的类加载器加载本类
        Object obj1 = ClassLoaderTest.class.getClassLoader().loadClass("com.study.sstream.classloader.ClassLoaderTest").newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof com.study.sstream.classloader.ClassLoaderTest);

        // 使用自定义类加载器加载本类
        Object obj2 = myLoader.loadClass("com.study.sstream.classloader.ClassLoaderTest").newInstance();
        System.out.println(obj2.getClass());
        System.out.println(obj2 instanceof com.study.sstream.classloader.ClassLoaderTest);
    }
}