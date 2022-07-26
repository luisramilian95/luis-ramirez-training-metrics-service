package com.xumak.metrics.dao.impl;

import com.xumak.metrics.dao.BatchLoaderDAO;
import com.xumak.metrics.model.BatchLoader;
import com.xumak.metrics.model.dto.BatchLoaderDTO;
import com.xumak.metrics.mapper.BatchLoaderMapper;
import com.xumak.metrics.repository.BatchLoaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class BatchLoaderDAOImpl implements BatchLoaderDAO {

    @Autowired
    BatchLoaderRepository repository;

    @Autowired
    BatchLoaderMapper mapper;

    @Override
    public BatchLoaderDTO getById(Long id) {
        Optional<BatchLoader> batchLoader = repository.findById(id);
        return mapper.toBatchLoaderDTO(batchLoader.orElse(null));
    }

    @Override
    public List<BatchLoaderDTO> getByTimestamp(Date start, Date end) {
        return null;
    }

    @Override
    public Boolean save(BatchLoaderDTO batchLoaderDTO) {
        BatchLoader batchLoader = mapper.toBatchLoader(batchLoaderDTO);
        batchLoader = repository.save(batchLoader);
        return  repository.existsById(batchLoader.getId());
    }
}
