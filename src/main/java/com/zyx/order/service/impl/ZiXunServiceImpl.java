package com.zyx.order.service.impl;

import com.zyx.order.dao.CustomerMapper;
import com.zyx.order.dao.ZiXunMapper;
import com.zyx.order.entity.Customer;
import com.zyx.order.entity.ZiXun;
import com.zyx.order.entity.ZiXunExample;
import com.zyx.order.service.ZiXunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZiXunServiceImpl implements ZiXunService {

    @Resource
    private ZiXunMapper ziXunMapper;
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<ZiXun> list() {
        ZiXunExample example = new ZiXunExample();
        example.createCriteria().andStatusEqualTo(1);
        List<ZiXun> ziXuns = ziXunMapper.selectByExample(example);
        for (ZiXun z:ziXuns){
            Customer customer =customerMapper.selectByPrimaryKey(z.getCstid());
            z.setCustomer(customer);
        }
        return ziXuns;
    }

    @Override
    public void save(ZiXun entity) {
        ziXunMapper.insert(entity);
    }

    @Override
    public void del(int id) {
        ziXunMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ZiXun get(int id) {
        return ziXunMapper.selectByPrimaryKey(id);
    }

    @Override
    public void shenhe(int zid) {
        ziXunMapper.shenhe(zid);
    }

    @Override
    public List<ZiXun> list1() {
        List<ZiXun> ziXuns = ziXunMapper.selectByExample(null);
        for (ZiXun z:ziXuns){
            Customer customer =customerMapper.selectByPrimaryKey(z.getCstid());
            z.setCustomer(customer);
        }
        return ziXuns;
    }
}
