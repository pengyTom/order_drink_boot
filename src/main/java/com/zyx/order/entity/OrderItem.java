package com.zyx.order.entity;


import lombok.Data;

@Data
public class OrderItem {
    private Integer id;

    private Integer pid;

    private Integer oid;

    private Integer cstid;

    private Integer number;

    private Product product;

}