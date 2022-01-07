package com.zyx.order.service.impl;


import com.zyx.order.dao.RoleMapper;
import com.zyx.order.dao.UserRoleMapper;
import com.zyx.order.entity.*;
import com.zyx.order.service.RoleService;
import com.zyx.order.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;
    @Resource
    UserRoleMapper userRoleMapper;
    @Resource
    UserService userService;

    @Override
    public Set<String> listRoleNames(String userName) {
        Set<String> result = new HashSet<>();
        //查出管理员相应的角色
        List<Role> roles = listRoles(userName);
        //把每个角色名放到set集合中
        for (Role role : roles) {
            result.add(role.getName());
        }
        return result;
    }

    @Override
    public List<Role> listRoles(String userName) {
        List<Role> roles = new ArrayList<>();
        //通过name获得user实体
        User user = userService.getByName(userName);
        if (null == user) {
            return roles;
        }
        //调用下面的方法
        roles = listRoles(user);
        return roles;
    }

    @Override
    public List<Role> listRoles(User user) {
        List<Role> roles = new ArrayList<>();
        //通过管理员id获取管理员的角色
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUidEqualTo(user.getId());
        //关联查询  查出用户id对应的角色id的记录
        List<UserRole> userRoles = userRoleMapper.selectByExample(example);

        //通过关联查询 ，查出表Role的给出指定主键id的记录
        for (UserRole userRole : userRoles) {
            Role role = roleMapper.selectByPrimaryKey(userRole.getRid());
            roles.add(role);
        }
        return roles;
    }

    @Override
    public List<Role> list() {
        RoleExample example = new RoleExample();
        example.setOrderByClause("id desc");
        return roleMapper.selectByExample(example);
    }

    @Override
    public void add(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void delete(Long id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role get(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }
}
