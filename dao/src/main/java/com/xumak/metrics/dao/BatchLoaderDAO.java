package com.xumak.metrics.dao;

import com.xumak.metrics.model.BatchLoader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchLoaderDAO extends CrudRepository<BatchLoader, Long> {
}
