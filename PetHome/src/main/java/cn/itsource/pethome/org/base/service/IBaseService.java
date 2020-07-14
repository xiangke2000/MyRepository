package cn.itsource.pethome.org.base.service;


import cn.itsource.pethome.org.util.PageList;
import cn.itsource.pethome.org.base.query.BaseQuery;

import java.io.Serializable;
import java.util.List;

/**
 * @version v1.8
 * @ProjectName: Pethome_02
 * @ClassName: BaseService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Think
 * @Date: 2020/7/10 12:42
 */
public interface IBaseService<T> {
    /**
     * 添加
     * @param t
     */
    void save(T t);

    /**
     * Serializable  number 的接口
     * @param id
     */
    void delete(Serializable id);

    /**
     * 删除多个
     * @param id
     */
    void deleteMore(Serializable id);

    /**
     * 修改
     * @param t
     */
    void update(T t);

    /**
     * 查询单个
     * @param id
     * @return
     */
    T findOne(Serializable id);

    /**
     * 查询全部
     * @return
     */
    List<T> findAll();

    /**
     * 高级查询
     * @param query
     * @return
     */
    PageList<T> findByQuery(BaseQuery query);
}
