package com.zyx.order.dao;


import com.zyx.order.entity.Customer;
import com.zyx.order.entity.CustomerExample;

import java.util.List;

public interface CustomerMapper extends CrudDao<Customer>{

    List<Customer> selectByExample(CustomerExample example);

    /**
     * 开启用户会员状态
     * @param id
     */
    void enableStatus(int id);

}