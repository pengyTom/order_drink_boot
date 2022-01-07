package com.zyx.order.entity;

import lombok.Data;

import java.util.List;


@Data
public class Order {

    private Integer id;

    private String code;

    private String address;

    private Integer status;

    private Integer cstid;

    private List<OrderItem> orderItems;

    private Customer customer;

    private float total;

    private int totalNumber;

}