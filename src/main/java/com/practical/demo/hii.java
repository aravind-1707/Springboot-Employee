package com.practical.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hii {
    @GetMapping("/hello")
    public String hello()
    {
        return  "Hii..This is your First Day so learn to difficult";
    }
}


