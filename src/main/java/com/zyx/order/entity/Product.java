package com.zyx.order.entity;


import lombok.Data;

@Data
public class Product {
    private Integer id;

    private String name;

    private Float price;

    private Integer zan;

    private Integer number;

    private Integer status;

    private String imageurl;

    private String miaoshu;

    private Integer cid;

    private Long bid;

    private Category category;
    private User user;
}