package com.zyx.order.service;

import com.zyx.order.entity.Order;
import com.zyx.order.entity.OrderItem;

import java.util.List;

public interface OrderItemService extends CrudService<OrderItem> {

    /**
     * 更新订单项
     * @param c
     */
    void update(OrderItem c);

    /**
     * 根据用户id返回用户的订单项集合
     * @param cstid 用户id
     * @return
     */
    List<OrderItem> listByCustomer(int cstid);

    /**
     * 给订单集合中的每个订单设置有哪些订单项,设置订单项对应的商品，设置每个订单总价
     * @param os 订单集合
     */
    void fill(List<Order> os);

    /**
     * 给订单设置订单项，订单项对应的商品，订单总价
     * @param o
     */
    void fill(Order o);

}
