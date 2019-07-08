package com.example.project.dto;

import lombok.Data;

/**
 * @author hwq
 * @date 2019/06/05
 */
public class UserDTO {

    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
