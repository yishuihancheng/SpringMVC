package edu.scu.cs.tlzhang.proxy.cglib_proxy;

/**
 * Created by tlzhang on 2016/12/16.
 */
public class TestCglib {
    public static void main(String args[]){
        BookFacadeCglib bookFacadeCglib = new BookFacadeCglib();
        BookFacadeImp bookFacadeImp = (BookFacadeImp)bookFacadeCglib.getInstance(new BookFacadeImp());
        bookFacadeImp.addBook();
    }
}
