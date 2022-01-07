package com.zyx.order.dao;


import com.zyx.order.entity.Order;
import com.zyx.order.entity.OrderExample;

import java.util.List;

public interface OrderMapper extends CrudDao<Order>{

    List<Order> selectByExample(OrderExample example);

}