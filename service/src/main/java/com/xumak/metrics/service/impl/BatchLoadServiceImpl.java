package com.xumak.metrics.service.impl;

import com.xumak.metrics.dao.BatchLoaderDAO;
import com.xumak.metrics.service.IBatchLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchLoadServiceImpl implements IBatchLoadService {

    @Autowired
    BatchLoaderDAO dao;



}
