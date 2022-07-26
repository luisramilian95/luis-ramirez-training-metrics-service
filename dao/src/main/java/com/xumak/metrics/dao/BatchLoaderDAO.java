package com.xumak.metrics.dao;

import com.xumak.metrics.model.dto.BatchLoaderDTO;

import java.util.Date;
import java.util.List;

public interface BatchLoaderDAO {

    BatchLoaderDTO getById(Long id);

    List<BatchLoaderDTO> getByTimestamp(Date start, Date end);

    Boolean save(BatchLoaderDTO batchLoader);

}
