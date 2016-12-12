package edu.scu.cs.tlzhang.proxy.jdk_proxy.static_proxy;

/**
 * Created by tlzhang on 2016/12/9.
 * 委托类，包含账户处理逻辑
 */
public class CountImp implements Count {
    @Override
    public void queryCount() {
        System.out.println("查看账户方法...");

    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法...");
    }
}
