package com.example.project.service.impl;

import com.example.project.dao.CustomerMapper;
import com.example.project.dao.OrderMapper;
import com.example.project.model.Customer;
import com.example.project.model.Order;
import com.example.project.service.ICustomerService;
import com.example.project.service.IOrderService;
import com.example.project.mybatis.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author: wenqing
 * @date: 2019/07/08 20:58:09
 * @description: Order服务实现
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends AbstractService<Order> implements IOrderService {

    @Autowired
    private OrderMapper tblOrderMapper;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String createOrder(String customerNo, String goodsNo, BigDecimal amonut) {
        //1、查询用户是否存在
        try {
            customerService.selectUserInfo(customerNo);
        } catch (Exception e) {
            Customer customer = new Customer();
            customer.setCustomerNo("n1");
            customer.setMobile("13755588979");
            customer.setCreateTime(new Date());
            customer.setModifyTime(new Date());
            customerMapper.insert(customer);
        }
        //2、查询商品编号是否正确

        //3、创建订单

        //4、扣钱
        return null;
    }
}
