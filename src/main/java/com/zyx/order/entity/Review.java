package com.zyx.order.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
    private Integer id;

    private String content;

    private Integer cstid;

    private Integer pid;

    private Date createtime;

    private Customer customer;

    private Product product;

}