package com.xumak.metrics.controller;

import com.xumak.metrics.service.IPersonResolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person-resolution-metrics")
public class PersonResolutionController {
    
    @Autowired
    IPersonResolutionService service;

}
