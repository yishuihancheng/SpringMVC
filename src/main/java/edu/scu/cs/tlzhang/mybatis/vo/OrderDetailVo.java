package edu.scu.cs.tlzhang.mybatis.vo;

import edu.scu.cs.tlzhang.mybatis.entity.Vo;

/**
 * Created by tlzhang on 2016/12/19.
 */
public class OrderDetailVo extends Vo {
    private float totalPrice;

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
