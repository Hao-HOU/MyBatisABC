package com.acehouhao.proxy;

/**
 * Created by Hao HOU on 2017/5/27.
 * 用于简单测试
 */
public class Client {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.move();

        //使用继承方式
        //语句已删除

        //使用聚合方式
//        Car car = new Car();
//        Moveable moveable = new CarTimeProxy(car);
//        moveable.move();

        Car car = new Car();
        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
        CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
        carLogProxy.move();

//        Car car = new Car();
//        CarLogProxy carLogProxy = new CarLogProxy(car);
//        CarTimeProxy carTimeProxy = new CarTimeProxy(carLogProxy);
//        carTimeProxy.move();
    }
}
