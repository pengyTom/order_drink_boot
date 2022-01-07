package com.zyx.order.service.impl;


import com.zyx.order.dao.CategoryMapper;
import com.zyx.order.entity.Category;
import com.zyx.order.service.CategoryService;
import com.zyx.order.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private ProductService productService;

    @Override
    public List<Category> list() {
        return null;
    }

    @Override
    public void save(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void del(int id) {
        boolean cunzai = productService.findProByCid(id);
        if (!cunzai) {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }


}
