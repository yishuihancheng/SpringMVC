package edu.scu.cs.tlzhang.proxy.cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tlzhang on 2016/12/16.
 */
public class BookFacadeCglib implements MethodInterceptor {
    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        System.out.println("事务开始前");
        obj = method.invoke(this.target, objects);
        System.out.println("事务开始后");
        return obj;
    }
}
