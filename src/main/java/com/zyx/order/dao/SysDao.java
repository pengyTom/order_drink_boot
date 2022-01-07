package com.zyx.order.dao;

/**
 * 管理员模块公共方法
 * @param <T>
 */
public interface SysDao<T> {
    /**
     * 删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 动态保存数据
     * @param entity
     * @return
     */
    int insertSelective(T entity);

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);

    /**
     * 动态更新
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(T entity);
}
