package com.fisher.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by FisherBi on 2016/11/20.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/",method=GET)
    public String home(){
        return "home";
    }
}
