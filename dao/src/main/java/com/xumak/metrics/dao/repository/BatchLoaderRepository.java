package com.xumak.metrics.dao.repository;

import com.xumak.metrics.model.BatchLoader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchLoaderRepository extends JpaRepository<BatchLoader, Long> {
}
