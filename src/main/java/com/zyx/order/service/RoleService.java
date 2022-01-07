package com.zyx.order.service;

import com.zyx.order.entity.Role;
import com.zyx.order.entity.User;

import java.util.List;
import java.util.Set;

public interface RoleService {

    /**
     * 根据管理员名字获得所有拥有的角色名集合
     * @param userName
     * @return
     */
    Set<String> listRoleNames(String userName);

    /**
     * 当前管理员拥有的角色
     * @param userName
     * @return
     */
    List<Role> listRoles(String userName);

    /**
     * 当前管理员的所有角色实体列表
     * @param user
     * @return
     */
    List<Role> listRoles(User user);

    /**
     * 数据库所有的角色
     * @return
     */
    List<Role> list();

    /**
     * 添加角色
     * @param role
     */
    void add(Role role);

    /**
     * 删除角色
     * @param id
     */
    void delete(Long id);

    /**
     * 获得一条角色
     * @param id
     * @return
     */
    Role get(Long id);

    /**
     * 更新角色
     * @param role
     */
    void update(Role role);
}
