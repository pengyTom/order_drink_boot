package com.zyx.order.dao;


import com.zyx.order.entity.Permission;
import com.zyx.order.entity.PermissionExample;

import java.util.List;

public interface PermissionMapper extends SysDao<Permission> {

    List<Permission> selectByExample(PermissionExample example);

}