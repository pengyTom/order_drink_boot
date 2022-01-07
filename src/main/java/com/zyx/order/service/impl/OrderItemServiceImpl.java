package com.zyx.order.service.impl;

import com.zyx.order.dao.OrderItemMapper;
import com.zyx.order.entity.Order;
import com.zyx.order.entity.OrderItem;
import com.zyx.order.entity.OrderItemExample;
import com.zyx.order.entity.Product;
import com.zyx.order.service.OrderItemService;
import com.zyx.order.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Resource
    OrderItemMapper orderItemMapper;
    @Resource
    ProductService productService;

    @Override
    public void save(OrderItem c) {
        orderItemMapper.insert(c);
    }

    @Override
    public void del(int id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(OrderItem c) {
        orderItemMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public OrderItem get(int id) {
        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
        setProduct(result);
        return result;
    }

    @Override
    public List<OrderItem> list() {
        OrderItemExample example = new OrderItemExample();
        example.setOrderByClause("id asc");
        return orderItemMapper.selectByExample(example);

    }

    @Override
    public void fill(List<Order> os) {
        for (Order o : os) {
            fill(o);
        }
    }

    /**
     * 1. 根据订单id查询出其对应的所有订单项
     * 2. 通过setProduct为所有的订单项设置Product属性
     * 3. 遍历所有的订单项，然后计算出该订单的总金额和总数量
     * 4. 最后再把订单项设置在订单的orderItems属性上。
     *
     * @param o 订单实体
     */
    @Override
    public void fill(Order o) {
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andOidEqualTo(o.getId());
        example.setOrderByClause("id asc");
        //查出当前订单下的所有订单项
        List<OrderItem> ois = orderItemMapper.selectByExample(example);
        //现在当前订单的每个订单项都有商品属性
        setProduct(ois);
//该订单总金额
        float total = 0;
        //该订单总数
        int totalNumber = 0;
        for (OrderItem oi : ois) {
            //数量 * 单价
            total += oi.getNumber() * oi.getProduct().getPrice();
            totalNumber += oi.getNumber();
        }
        //设置总金额
        o.setTotal(total);
        o.setTotalNumber(totalNumber);
        //当前订单的订单项
        o.setOrderItems(ois);

    }

    private void setProduct(List<OrderItem> ois) {
        for (OrderItem oi : ois) {
            setProduct(oi);
        }
    }

    private void setProduct(OrderItem oi) {
        Product p = productService.get(oi.getPid());
        oi.setProduct(p);
    }

    @Override
    public List<OrderItem> listByCustomer(int cstid) {//根据用户id查询orderitem表中oid为空的集合
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andCstidEqualTo(cstid).andOidIsNull();
        List<OrderItem> result = orderItemMapper.selectByExample(example);
        setProduct(result);
        return result;
    }
}
