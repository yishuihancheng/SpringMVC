package edu.scu.cs.tlzhang.mybatis.entity;

/**
 * Created by tlzhang on 2016/12/20.
 */
public class CustomOrder extends Order {
    private String name;
    private Gender gender;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
