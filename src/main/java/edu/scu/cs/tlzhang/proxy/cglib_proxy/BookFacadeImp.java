package edu.scu.cs.tlzhang.proxy.cglib_proxy;


/**
 * Created by tlzhang on 2016/12/16.
 */
public class BookFacadeImp implements BookFacade{
    @Override
    public void addBook() {
        System.out.println("增加图书的普通方法...");
    }
}
