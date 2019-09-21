package com.dlj.dao.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter

public class Item {
    // 商品id
    private int id;
    // 商品名称
    private String name;
    // 商品价格
    private double price;
    // 商品创建时间
    private Date createtime;
    // 商品描述
    private String detail;



    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createtime=" + createtime +
                ", detail='" + detail + '\'' +
                '}';
    }
}