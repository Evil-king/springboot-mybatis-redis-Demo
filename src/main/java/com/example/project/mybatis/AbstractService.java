package com.example.project.mybatis;


import com.example.project.page.MyPageInfo;
import com.example.project.page.PageParam;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author: wenqing
 * @date: 2017/7/6 17:22
 * @description: 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected MyMapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public boolean save(T model) {

        return mapper.insertSelective(model) > 0;
    }

    @Override
    public void save(List<T> models) {
        mapper.insertList(models);
    }

    @Override
    public boolean deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public boolean update(T model) {
        return mapper.updateByPrimaryKeySelective(model) > 0;
    }

    @Override
    public boolean updateByConditionSelective(T model, Condition condition) {
        return mapper.updateByConditionSelective(model, condition) > 0;
    }

    @Override
    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public T findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int selectCountByCondition(Condition condition) {
        return mapper.selectCountByCondition(condition);
    }

    @Override
    public MyPageInfo<T> pageList(Condition condition, PageParam pageParam) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize());
        if (!StringUtils.isEmpty(pageParam.getSort()) && !StringUtils.isEmpty(pageParam.getOrder())) {
            PageHelper.orderBy(new StringBuffer().append(pageParam.getSort()).append(" ").append(pageParam.getOrder()).toString());
        }
        List<T> list = this.findByCondition(condition);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        MyPageInfo<T> myPageInfo = new MyPageInfo<>(list);
        return myPageInfo;
    }
}
