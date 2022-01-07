package com.zyx.order.service;

import com.zyx.order.entity.Role;

public interface RolePermissionService {

    /**
     * 设置角色能拥有的权限
     * @param role 角色
     * @param permissionIds 权限ids
     */
    void setPermissions(Role role, long[] permissionIds);

    /**
     * 根据角色id删除角色下的所有权限
     * @param roleId
     */
    void deleteByRole(long roleId);

    /**
     * 根据权限id删除一条权限
     * @param permissionId
     */
    void deleteByPermission(long permissionId);
}
