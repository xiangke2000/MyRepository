package cn.itsource.pethome.org.base.service.impl;

import cn.itsource.pethome.org.util.PageList;
import cn.itsource.pethome.org.base.mapper.BaseMapper;
import cn.itsource.pethome.org.base.query.BaseQuery;
import cn.itsource.pethome.org.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @version v1.8
 * @ProjectName: Pethome_02
 * @ClassName: IBaseService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Think
 * @Date: 2020/7/10 15:53
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    /**
     * 添加
     * @param t
     */
    @Override
    @Transactional
    public void save(T t) {
        baseMapper.save(t);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional
    public void delete(Serializable id) {
        baseMapper.delete(id);
    }

    /**
     * 批量删除
     * @param id
     */
    @Override
    @Transactional
    public void deleteMore(Serializable id) {
        baseMapper.deleteMore(id);
    }

    /**
     * 修改
     * @param t
     */
    @Override
    @Transactional
    public void update(T t) {
        baseMapper.update(t);
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @Override
    public T findOne(Serializable id) {
        return baseMapper.findOne(id);
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<T> findAll() {
        return baseMapper.findAll() ;
    }

    /**
     * 高级查询
     * @param query
     * @return
     */
    @Override
    public PageList<T> findByQuery(BaseQuery query) {
        PageList<T> list = new PageList<>();
        Integer count = baseMapper.queryCount(query);
        if (count==null || count==0){
            return list;
        }
        //设置数据总条数
        list.setTotal(count);
        //高级查询返回指定数据
        List<T> base = baseMapper.findByQuery(query);
        //设置数据
        list.setList(base);
        return list;
    }
}
