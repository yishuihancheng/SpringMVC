package edu.scu.cs.tlzhang.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tlzhang on 2016/12/16.
 */
public class User extends Basic implements Serializable{
    private Integer id;
    private String name;
    private String address;
    private Gender gender;
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
