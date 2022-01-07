package com.zyx.order.dao;


import com.zyx.order.entity.Role;
import com.zyx.order.entity.RoleExample;

import java.util.List;

public interface RoleMapper extends SysDao<Role> {

    List<Role> selectByExample(RoleExample example);

}