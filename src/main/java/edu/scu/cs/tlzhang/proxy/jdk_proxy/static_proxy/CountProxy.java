package edu.scu.cs.tlzhang.proxy.jdk_proxy.static_proxy;

/**
 * Created by tlzhang on 2016/12/9.
 */
public class CountProxy implements Count {
    private CountImp countImp;

    public CountProxy(CountImp countImp) {
        this.countImp = countImp;
    }

    @Override
    public void queryCount() {
        System.out.println("事务处理前");
        countImp.queryCount();
        System.out.println("事务处理后");
    }

    @Override
    public void updateCount() {
        System.out.println("事务处理前");
        countImp.updateCount();
        System.out.println("事务处理后");
    }
}
