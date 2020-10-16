package com.example.demo.controller;


import com.example.demo.enums.ResultEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        String valuesByCode = ResultEnum.getValuesByCode(0);
        System.out.println(valuesByCode);
        return "springboot";
    }
}
