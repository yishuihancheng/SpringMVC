package edu.scu.cs.tlzhang.proxy.jdk_proxy.static_proxy;

/**
 * Created by tlzhang on 2016/12/9.
 * 观察代码可以发现每一个代理类只能为一个接口服务，这样一来程序开发中必然会产生过多的代理，
 * 而且，所有的代理操作除了调用的方法不一样之外，其他的操作都一样，则此时肯定是重复代码。
 * 解决这一问题最好的做法是可以通过一个代理类完成全部的代理功能，那么此时就必须使用动态代理完成。
 */
public class TestCount {
    public static void main(String args[]){
        Count count = new CountProxy(new CountImp());
        count.queryCount();
        count.updateCount();
    }
}
