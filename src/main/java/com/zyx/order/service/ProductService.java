package com.zyx.order.service;

import com.zyx.order.entity.Category;
import com.zyx.order.entity.Product;
import com.zyx.order.entity.ProductVO;
import com.zyx.order.entity.User;

import java.util.List;

public interface ProductService extends CrudService<Product>{

    /**
     * 商品上线
     * @param name
     * @return
     */
    String enableStatus(String name);

    /**
     * 商品下线
     * @param name
     * @return
     */
    String stopStatus(String name);

    /**
     * 设置商品图片保存位置
     * @param vo
     */
    void setImageURL(ProductVO vo);

    /**
     * 获得分类实体
     * @param id 分类id
     * @return
     */
    Category getCategoryByCid(int id);

    /**
     * 更新商品
     * @param product
     */
    void update(Product product);

    /**
     *  获取分类下的所有上线商品列表
     * @param id
     * @return
     */
    List<Product> getProductsByCid(Integer id);

    /**
     * 获得商品所属商家
     * @param id 商家id
     * @return
     */
    User getUserByBid(long id);

    /**
     * 模糊搜索
     * @param pName 商品name
     * @return 商品集合
     */
    List<Product> findByName(String pName);

    /**
     *
     * @param cid
     * @return
     */
    List<Product> findByCid(int cid);

   boolean findProByCid(int id);

}
