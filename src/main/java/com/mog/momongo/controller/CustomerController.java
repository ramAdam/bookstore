package com.mog.momongo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ControllerDemo
 */
@Controller
public class CustomerController {

    @RequestMapping("/")
    public @ResponseBody String greeting(){
        return "Hello World";
    } 
    
}