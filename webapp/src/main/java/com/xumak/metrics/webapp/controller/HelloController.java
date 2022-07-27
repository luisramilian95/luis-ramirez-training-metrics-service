package com.xumak.metrics.webapp.controller;

import com.xumak.metrics.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private IService service;

    @GetMapping
    public String hello() {
        return service.hello();
    }

}
