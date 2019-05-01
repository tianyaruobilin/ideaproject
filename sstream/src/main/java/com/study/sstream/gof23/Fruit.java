package com.study.sstream.gof23;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface Fruit {
    void eat();
}

class Apple implements Fruit{

    @Override
    public void eat() {
        System.out.println("apple");
    }
}

class Orange implements Fruit{

    @Override
    public void eat() {
        System.out.println("orange");
    }
}

class Factory{
    public static Fruit getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Fruit fruit = (Fruit) Class.forName(className).newInstance();
        return fruit;
    }
}

class Hello{
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Hello.class.getResourceAsStream("fruit.properties");

        Properties properties=new Properties();
        properties.load(resourceAsStream);
        try {
            Fruit instance = Factory.getInstance((String) properties.get("apple"));
            if (instance != null) {
                instance.eat();
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("工厂创建类失败");
        }
    }
}
