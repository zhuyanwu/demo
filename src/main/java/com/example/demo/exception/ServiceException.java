package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

public class ServiceException extends RuntimeException{

    private Integer code;

    public ServiceException (ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
