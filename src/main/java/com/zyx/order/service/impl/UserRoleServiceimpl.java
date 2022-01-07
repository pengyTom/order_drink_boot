package com.zyx.order.service.impl;

import com.zyx.order.dao.UserRoleMapper;
import com.zyx.order.entity.User;
import com.zyx.order.entity.UserRole;
import com.zyx.order.entity.UserRoleExample;
import com.zyx.order.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceimpl implements UserRoleService {

    @Resource
    UserRoleMapper userRoleMapper;

    @Override
    public void setRoles(User user, long[] roleIds) {
        //删除当前管理员所有的角色
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUidEqualTo(user.getId());

        List<UserRole> urs = userRoleMapper.selectByExample(example);

        for (UserRole userRole : urs) {
            userRoleMapper.deleteByPrimaryKey(userRole.getId());
        }

        //设置新的角色关系
        if (null != roleIds) {
            for (long rid : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setRid(rid);
                //插入管理员新的所有权限
                userRole.setUid(user.getId());
                userRoleMapper.insert(userRole);
            }
        }
    }

    @Override
    public void deleteByUser(long userId) {
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUidEqualTo(userId);
        //urs:传进来的管理员的id去作为条件查询UserRole表的记录的集合
        List<UserRole> urs = userRoleMapper.selectByExample(example);
        //依次删除记录
        urs.forEach(userRole -> userRoleMapper.deleteByPrimaryKey(userRole.getId()));
    }

    @Override
    public void deleteByRole(long roleId) {
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andRidEqualTo(roleId);
        //查询UserRole表为角色id的记录  下面删除
        List<UserRole> urs = userRoleMapper.selectByExample(example);
        for (UserRole userRole : urs) {
            userRoleMapper.deleteByPrimaryKey(userRole.getId());
        }
    }
}
