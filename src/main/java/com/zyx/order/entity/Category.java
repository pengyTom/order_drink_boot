package com.zyx.order.entity;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer id;

    private String name;

    private List<com.zyx.order.entity.Product> products;

}