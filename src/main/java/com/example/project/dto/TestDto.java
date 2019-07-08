package com.example.project.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hwq
 * @date 2019/05/31
 */
@Data
public class TestDto {

    private BigDecimal price;

    private String customerNo;

    private String goodsNo;

}
