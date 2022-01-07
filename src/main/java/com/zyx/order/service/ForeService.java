package com.zyx.order.service;

import com.zyx.order.entity.Category;
import com.zyx.order.entity.Product;

import java.util.List;

public interface ForeService {

    /**
     * 返回保存6个分类对象的List集合
     * @return
     */
    List<Category> listToThree();

    List<Product> getFivePro();

}
