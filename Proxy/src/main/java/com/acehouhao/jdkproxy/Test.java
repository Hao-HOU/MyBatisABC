package com.acehouhao.jdkproxy;

import com.acehouhao.proxy.Car;
import com.acehouhao.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Hao HOU on 2017/5/27.
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();

         Moveable moveable = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
         moveable.move();
    }
}
