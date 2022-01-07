package com.zyx.order.service;

import com.zyx.order.entity.Category;

public interface CategoryService extends CrudService<Category> {
    /**
     * 更新分类
     * @param category
     */
    void update(Category category);
}
