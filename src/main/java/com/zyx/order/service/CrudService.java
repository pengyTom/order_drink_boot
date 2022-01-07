package com.zyx.order.service;

import java.util.List;

public interface CrudService<T> {

    /**
     * 所有数据
     * @return
     */
    List<T> list();

    /**
     * 保存数据
     * @param entity
     */
    void save(T entity);

    /**
     * 删除数据
     * @param id
     */
    void del(int id);

    /**
     * 获得单条数据
     * @param id
     * @return
     */
    T get(int id);

}
