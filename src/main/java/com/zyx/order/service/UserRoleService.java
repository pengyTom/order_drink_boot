package com.zyx.order.service;

import com.zyx.order.entity.User;

public interface UserRoleService {

    /**
     * 给管理员设置角色s
     * @param user
     * @param roleIds
     */
    void setRoles(User user, long[] roleIds);

    /**
     * 删除当前管理员的所有角色
     * @param userId
     */
    void deleteByUser(long userId);

    /**
     * 根据角色id删除权限 删除所有拥有传入角色的权限记录
     * @param roleId
     */
    void deleteByRole(long roleId);
}
