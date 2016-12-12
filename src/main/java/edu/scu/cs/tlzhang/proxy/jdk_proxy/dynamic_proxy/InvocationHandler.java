package edu.scu.cs.tlzhang.proxy.jdk_proxy.dynamic_proxy;

import java.lang.reflect.Method;

/**
 * Created by tlzhang on 2016/12/9.
 * 模拟动态代理
 */
public interface InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
