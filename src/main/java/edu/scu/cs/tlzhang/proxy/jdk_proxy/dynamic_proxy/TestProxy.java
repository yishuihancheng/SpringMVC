package edu.scu.cs.tlzhang.proxy.jdk_proxy.dynamic_proxy;

import java.lang.reflect.Constructor;

/**
 * Created by tlzhang on 2016/12/9.
 */
public class TestProxy {
    public static void main(String args[]){
        BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) bookFacadeProxy.bind(new BookFacadeImp());
        Constructor<?>[] constructors = bookFacade.getClass().getConstructors();

        System.out.println(bookFacade.getClass().getConstructors());
        System.out.println("main:proxy--" + bookFacadeProxy);
        bookFacade.addBook();
        bookFacade.deleteBook();
    }
}
