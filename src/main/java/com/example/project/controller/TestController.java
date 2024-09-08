package com.example.project.controller;

import com.example.project.api.ApiResult;
import com.example.project.model.Product;
import com.example.project.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/admin/getId", method = RequestMethod.GET)
    public ApiResult<List<Product>> getAccount() {
        List<Product> product = productService.getData();
        return ApiResult.success(product);
    }
}
