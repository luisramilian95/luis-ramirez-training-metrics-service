package com.xumak.metrics.service.impl;

import com.xumak.metrics.dao.BatchLoaderDAO;
import com.xumak.metrics.model.dto.AppResponse;
import com.xumak.metrics.model.dto.BatchLoaderDTO;
import com.xumak.metrics.service.IMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Qualifier("BatchLoaderService")
public class BatchLoadServiceImpl implements IMetricService<BatchLoaderDTO> {

    @Autowired
    BatchLoaderDAO dao;

    @Override
    public AppResponse persist(BatchLoaderDTO batchLoader) {
        AppResponse response =  new AppResponse();
        response.setStatus(dao.save(batchLoader));
        return response;
    }

    @Override
    public BatchLoaderDTO getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public List<BatchLoaderDTO> getByTimestamps(Date start, Date end) {
        return dao.getByTimestamp(start, end);
    }
}
