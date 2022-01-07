package com.zyx.order.service.impl;


import com.zyx.order.dao.RolePermissionMapper;
import com.zyx.order.entity.Role;
import com.zyx.order.entity.RolePermission;
import com.zyx.order.entity.RolePermissionExample;
import com.zyx.order.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Resource
    RolePermissionMapper rolePermissionMapper;

    @Override
    public void setPermissions(Role role, long[] permissionIds) {
        //删除当前角色所有的权限
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRidEqualTo(role.getId());
        List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission : rps) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }

        //设置新的权限关系
        if (null != permissionIds) {
            for (long pid : permissionIds) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setPid(pid);
                rolePermission.setRid(role.getId());
                rolePermissionMapper.insert(rolePermission);
            }
        }
    }

    @Override
    public void deleteByRole(long roleId) {
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRidEqualTo(roleId);
        List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission : rps) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }
    }

    @Override
    public void deleteByPermission(long permissionId) {
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andPidEqualTo(permissionId);
        List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission : rps) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }
    }
}
