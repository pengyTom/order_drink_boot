package com.zyx.order.dao;


import com.zyx.order.entity.Category;
import com.zyx.order.entity.CategoryExample;

import java.util.List;

public interface CategoryMapper extends CrudDao<Category>{

     List<Category> selectByExample(CategoryExample example);

}