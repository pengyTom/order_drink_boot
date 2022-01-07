package com.zyx.order.dao;


import com.zyx.order.entity.RolePermission;
import com.zyx.order.entity.RolePermissionExample;

import java.util.List;

public interface RolePermissionMapper extends SysDao<RolePermission>{

    List<RolePermission> selectByExample(RolePermissionExample example);

}