package com.example.project.exception;


import com.example.project.api.ResultEnum;

/**
 * @author: wenqing
 * @date: 2019/4/4 6:34 PM
 * @description: 服务层异常
 */
public class ServiceException extends RuntimeException {
    // 异常码
    private Integer code;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
