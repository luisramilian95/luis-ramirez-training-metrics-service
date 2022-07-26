package com.xumak.metrics.repository;

import com.xumak.metrics.model.BatchLoader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchLoaderRepository extends CrudRepository<BatchLoader, Long> {
}
