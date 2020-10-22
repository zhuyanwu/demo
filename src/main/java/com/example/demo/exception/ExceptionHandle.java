package com.example.demo.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class )
    @ResponseBody
    public String handle(Exception e){
        logger.info("error = {}",e);
        if(e instanceof ServiceException){
            ServiceException serviceException = (ServiceException) e;
            return serviceException.getCode()+"and " + serviceException.getMessage();
        }
        return e.getMessage();
    }
}
