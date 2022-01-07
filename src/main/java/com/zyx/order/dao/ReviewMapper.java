package com.zyx.order.dao;


import com.zyx.order.entity.Review;
import com.zyx.order.entity.ReviewExample;

import java.util.List;

public interface ReviewMapper extends CrudDao<Review>{

    List<Review> selectByExample(ReviewExample example);

}