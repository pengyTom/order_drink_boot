package com.zyx.order.entity;

import lombok.Data;

@Data
public class Customer {
    private Integer id;

    private String name;

    private String password;

    private String address;

    private String phone;

    private Integer status;

}