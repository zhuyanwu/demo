package com.example.demo.enums;

import javax.xml.transform.Result;

public enum ResultEnum {

    SUCCESS(0,"OK"),
    ERROR(1,"NO"),
    ;
    private Integer code;

    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getValuesByCode(Integer code){
        for(ResultEnum resultEnum : ResultEnum.values()){
            if(resultEnum.getCode().equals(code)){
                return resultEnum.getMessage();
            }
        }
        return "";
    }

}
