package com.example.project.service;

import com.example.project.model.Order;
import com.example.project.mybatis.Service;

import java.math.BigDecimal;

/**
 * @author: wenqing
 * @date: 2019/07/08 20:58:09
 * @description: Order服务接口
 */
public interface IOrderService extends Service<Order> {

    String createOrder(String customerNo, String goodsNo, BigDecimal amonut);

}
