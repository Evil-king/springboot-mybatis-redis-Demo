package com.example.project.service;
import com.example.project.model.Customer;
import com.example.project.mybatis.Service;

/**
* @author: wenqing
* @date: 2019/07/08 20:51:19
* @description: Customer服务接口
*/
public interface ICustomerService extends Service<Customer> {

    void selectUserInfo(String customerNo);

}
