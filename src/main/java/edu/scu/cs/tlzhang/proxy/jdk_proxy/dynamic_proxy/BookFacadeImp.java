package edu.scu.cs.tlzhang.proxy.jdk_proxy.dynamic_proxy;

/**
 * Created by tlzhang on 2016/12/9.
 */
public class BookFacadeImp implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");

    }

    @Override
    public void deleteBook() {
        System.out.println("删除图书方法。。。");
    }

    public void queryBook(){
        System.out.println("queryBook");
    }

    public static void main(String args[]){
        BookFacadeImp bookFacadeImp = new BookFacadeImp();
        Class<?>[] interfaces = bookFacadeImp.getClass().getInterfaces();
        System.out.println(interfaces);
    }
}
