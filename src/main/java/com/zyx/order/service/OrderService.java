package com.zyx.order.service;

import com.zyx.order.entity.Order;
import com.zyx.order.entity.OrderItem;

import java.util.List;

public interface OrderService extends CrudService<Order> {

    /**
     * 更新订单
     * @param c
     */
    void update(Order c);

    /**
     * 生成完整订单
     * @param o 订单
     * @param ois 订单项
     * @return
     */
    float add(Order o, List<OrderItem> ois);

    /**
     * 用户订单列表
     * @param cstid 用户id
     * @return
     */
    List<Order> list(int cstid);

}
