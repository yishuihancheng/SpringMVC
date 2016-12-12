package edu.scu.cs.tlzhang.proxy.jdk_proxy.dynamic_proxy;

/**
 * Created by tlzhang on 2016/12/9.
 */
public class BookFacadeImp implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }
}
