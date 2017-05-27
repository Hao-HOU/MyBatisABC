package com.acehouhao.proxy;

import java.util.Random;

/**
 * Created by Hao HOU on 2017/5/27.
 */
public class Car implements Moveable {
    @Override
    public void move() {
        //实实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
