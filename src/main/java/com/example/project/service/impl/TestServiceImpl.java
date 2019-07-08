package com.example.project.service.impl;

import com.example.project.dao.CustomerMapper;
import com.example.project.model.Customer;
import com.example.project.process.TestProcess;
import com.example.project.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;


/**
 * @author hwq
 * @date 2019/07/08
 */
@Service
public class TestServiceImpl extends TestProcess {

    @Autowired
    private CustomerMapper tblCustomerMapper;
    @Autowired
    private ICustomerService customerService;

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void createOrder(String customerNo) {
        customerService.selectUserInfo(customerNo);
    }

//    public void selectUserInfo(String customerNo) {
//        Condition condition = new Condition(Customer.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo("customerNo",customerNo);
//        List<Customer> customerList = tblCustomerMapper.selectByCondition(condition);
//        if(customerList.size() == 0){
//            Customer customer = new Customer();
//            customer.setCustomerNo("n2");
//            customer.setMobile("13755588979");
//            customer.setCreateTime(new Date());
//            customer.setModifyTime(new Date());
//            tblCustomerMapper.insert(customer);
//        }
//    }
}
