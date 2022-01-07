package com.zyx.order.entity;

import lombok.Data;

import java.util.Date;


@Data
public class ZiXun {
    private Integer id;

    private String content;

    private Integer cstid;

    private Integer status;

    private Date fabudate;

    private Customer customer;
}