package com.xumak.metrics.service.impl;

import com.xumak.metrics.service.IService;
import org.springframework.stereotype.Service;

@Service
class ServiceImpl implements IService {

    @Override
    public String hello() {
        return "Hello World!";
    }
}