package com.alldaypa.security2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "Home Page";
    }

}
