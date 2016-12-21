package edu.scu.cs.tlzhang.mybatis.entity;

/**
 * Created by tlzhang on 2016/12/16.
 */
public enum Gender {
    male("男"),female("女");
    private String name;
    Gender(String name){
        this.name = name;
    }
}
