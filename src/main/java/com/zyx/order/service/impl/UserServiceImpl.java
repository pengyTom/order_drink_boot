package com.zyx.order.service.impl;

import com.zyx.order.dao.ProductMapper;
import com.zyx.order.dao.UserMapper;
import com.zyx.order.entity.Product;
import com.zyx.order.entity.User;
import com.zyx.order.entity.UserExample;
import com.zyx.order.service.UserRoleService;
import com.zyx.order.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserRoleService userRoleService;
    @Resource
    ProductMapper productMapper;

    @Override
    public String getPassword(String name) {
        User u = getByName(name);
        if (null == u) {
            return null;
        }
        return u.getPassword();
    }

    @Override
    public User getByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public List<User> list() {

        return userMapper.selectByExample(null);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteByPrimaryKey(id);
        userRoleService.deleteByUser(id);
    }

    @Override
    public User get(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public String enableStatus(String name) {
        userMapper.enableStatus(name);
        return "success";
    }

    @Override
    public String stopStatus(String name) {
        userMapper.stopStatus(name);
        return "success";
    }

    @Override
    public User getUserByPid(int id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return userMapper.selectByPrimaryKey(product.getBid());
    }


}