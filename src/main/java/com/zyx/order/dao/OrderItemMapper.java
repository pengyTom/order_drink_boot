package com.zyx.order.dao;


import com.zyx.order.entity.OrderItem;
import com.zyx.order.entity.OrderItemExample;

import java.util.List;

public interface OrderItemMapper extends CrudDao<OrderItem>{

    List<OrderItem> selectByExample(OrderItemExample example);

}