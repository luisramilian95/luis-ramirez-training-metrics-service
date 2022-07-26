package com.xumak.metrics.controller;

import com.xumak.metrics.service.IBatchLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("batch-loader-metrics")
public class BatchLoaderController {

    @Autowired
    IBatchLoadService service;

    @GetMapping
    public String hello() {
        return "Hello World";
    }

}
