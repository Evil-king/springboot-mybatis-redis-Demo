package com.example.project.service.impl;

import com.example.project.dao.ProductMapper;
import com.example.project.model.Product;
import com.example.project.service.IProductService;
import com.example.project.mybatis.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
* @author: wenqing
* @date: 2019/05/27 23:17:32
* @description: Product服务实现
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl extends AbstractService<Product> implements IProductService {

    @Autowired
    private ProductMapper tblProductMapper;

    @Override
    public List<Product> getData() {
        Condition condition = new Condition(Product.class);
        return tblProductMapper.selectByCondition(condition);
    }
}
