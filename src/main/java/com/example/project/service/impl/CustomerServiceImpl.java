package com.example.project.service.impl;

import com.example.project.dao.CustomerMapper;
import com.example.project.exception.ServiceException;
import com.example.project.model.Customer;
import com.example.project.service.ICustomerService;
import com.example.project.mybatis.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


/**
* @author: wenqing
* @date: 2019/07/08 20:51:19
* @description: Customer服务实现
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl extends AbstractService<Customer> implements ICustomerService {

    @Autowired
    private CustomerMapper tblCustomerMapper;

    @Override
    public void selectUserInfo(String customerNo) {
        Condition condition = new Condition(Customer.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("customerNo",customerNo);
        List<Customer> customerList = tblCustomerMapper.selectByCondition(condition);
        if(customerList.size() == 0){
            Customer customer = new Customer();
            customer.setCustomerNo("n2");
            customer.setMobile("13755588979");
            customer.setCreateTime(new Date());
            customer.setModifyTime(new Date());
            tblCustomerMapper.insert(customer);
        }
    }
}
