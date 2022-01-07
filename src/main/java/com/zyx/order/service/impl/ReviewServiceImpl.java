package com.zyx.order.service.impl;

import com.zyx.order.dao.CustomerMapper;
import com.zyx.order.dao.ProductMapper;
import com.zyx.order.dao.ReviewMapper;
import com.zyx.order.entity.Customer;
import com.zyx.order.entity.Product;
import com.zyx.order.entity.Review;
import com.zyx.order.entity.ReviewExample;
import com.zyx.order.service.ReviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Resource
    private ReviewMapper reviewMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Review> list() {
        List<Review> reviews = reviewMapper.selectByExample(null);
        for (Review review : reviews) {
            Customer customer = customerMapper.selectByPrimaryKey(review.getCstid());
            Product product = productMapper.selectByPrimaryKey(review.getPid());
            review.setCustomer(customer);
            review.setProduct(product);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewListByPid(int id) {
        ReviewExample example = new ReviewExample();
        example.createCriteria().andPidEqualTo(id);
        List<Review> reviews = reviewMapper.selectByExample(example);
        for (Review review : reviews) {
            Customer customer = customerMapper.selectByPrimaryKey(review.getCstid());
            review.setCustomer(customer);
        }

        return reviews;
    }

    @Override
    public void del(int id) {
        reviewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Review get(int id) {
        return reviewMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Review review) {
        reviewMapper.insert(review);
    }
}
