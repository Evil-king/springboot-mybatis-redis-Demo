package com.example.project.process;

import com.example.project.service.ITestService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hwq
 * @date 2019/07/08
 */
public abstract class TestProcess implements ITestService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void response(String customerNo) {
        try {
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        createOrder(customerNo);
    }

    public void createOrder(String customerNo){
    }
}
