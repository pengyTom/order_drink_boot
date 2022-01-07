package com.zyx.order.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {

    private Long id;

    private String name;

    private String password;

    private String salt;

    private Integer status;

    private String address;

    private String phone;

    private Date lasttime;

}