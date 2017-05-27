package com.acehouhao.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Hao HOU on 2017/5/27.
 */
public class TimeHandler implements InvocationHandler {
    private Object object;

    public TimeHandler(Object object) {
        super();
        this.object = object;
    }

    /**
     *
     * @param proxy 被代理的对象
     * @param method 被代理对象的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");

        method.invoke(object);

        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...");
        System.out.println("汽车行驶时间：" + (endTime - startTime) + "ms");
        return null;
    }
}
