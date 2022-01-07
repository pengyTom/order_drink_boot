package com.zyx.order.dao;


import com.zyx.order.entity.UserRole;
import com.zyx.order.entity.UserRoleExample;

import java.util.List;

public interface UserRoleMapper extends SysDao<UserRole>{

    List<UserRole> selectByExample(UserRoleExample example);

}