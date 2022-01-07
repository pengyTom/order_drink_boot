package com.zyx.order.service.impl;

import com.zyx.order.dao.ProductMapper;
import com.zyx.order.dao.UserMapper;
import com.zyx.order.entity.*;
import com.zyx.order.service.CategoryService;
import com.zyx.order.service.ProductService;
import com.zyx.order.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private CategoryService categoryService;
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<Product> list() {
        //获得商品列表
        List<Product> products = productMapper.selectByExample(null);
        for (Product p : products) {
            Category category = categoryService.get(p.getCid());
            p.setCategory(category);
            User user = userService.get(p.getBid());
            p.setUser(user);
        }
        return products;
    }

    @Override
    public String enableStatus(String name) {
        productMapper.enableStatus(name);
        return "success";
    }

    @Override
    public String stopStatus(String name) {
        productMapper.stopStatus(name);
        return "success";
    }

    @Override
    public void save(Product product) {
        product.setStatus(1);
        productMapper.insert(product);
    }

    @Override
    public void setImageURL(ProductVO vo) {
        productMapper.setImageUrl(vo);
    }

    @Override
    public Product get(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void del(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category getCategoryByCid(int id) {
        return categoryService.get(id);
    }

    @Override
    public void update(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List<Product> getProductsByCid(Integer id) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(id).andStatusEqualTo(1);
        return productMapper.selectByExample(example);
    }

    @Override
    public User getUserByBid(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> findByName(String pName) {
        ProductExample example = new ProductExample();
        example.createCriteria().andNameLike("%" + pName + "%");
        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> findByCid(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        return productMapper.selectByExample(example);
    }

    @Override
    public boolean findProByCid(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        List<Product> products = productMapper.selectByExample(example);
        return products.size() > 0 && products != null;
    }

}
