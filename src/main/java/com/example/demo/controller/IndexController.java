package com.example.demo.controller;


import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class IndexController {

    @GetMapping("/index")
    public String index() throws ServiceException{
        String valuesByCode = ResultEnum.getValuesByCode(0);
        System.out.println(valuesByCode);
        int a = 2/0;
        return "oooo";
    }
}
