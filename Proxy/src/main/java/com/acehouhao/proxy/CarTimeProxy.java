package com.acehouhao.proxy;

/**
 * Created by Hao HOU on 2017/5/27.
 */
public class CarTimeProxy implements Moveable {
    private Moveable moveable;
    public CarTimeProxy(Moveable moveable) {
        super();
        this.moveable = moveable;
    }
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");

        moveable.move();

        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...");
        System.out.println("汽车行驶时间：" + (endTime - startTime) + "ms");
    }
}
