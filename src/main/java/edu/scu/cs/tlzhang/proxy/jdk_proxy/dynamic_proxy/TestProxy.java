package edu.scu.cs.tlzhang.proxy.jdk_proxy.dynamic_proxy;

/**
 * Created by tlzhang on 2016/12/9.
 */
public class TestProxy {
    public static void main(String args[]){
        BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) bookFacadeProxy.bind(new BookFacadeImp());
        bookFacade.addBook();
    }
}
