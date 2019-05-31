package com.example.project.service;
import com.example.project.model.Product;
import com.example.project.mybatis.Service;

import java.util.List;

/**
* @author: wenqing
* @date: 2019/05/27 23:17:32
* @description: Product服务接口
*/
public interface IProductService extends Service<Product> {

    List<Product> getData();
}
