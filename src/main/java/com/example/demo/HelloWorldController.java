package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	    @RequestMapping("/hello")
	    public String index() {
	        return "大家好，我是渣渣辉，是个Springboot的demo";
	    }
	}
