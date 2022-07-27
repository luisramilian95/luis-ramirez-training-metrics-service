package com.xumak.metrics.dao.repository;

import com.xumak.metrics.model.BatchLoader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BatchLoaderRepository extends JpaRepository<BatchLoader, Long> {

    List<BatchLoader> findByTimestampBetween(Date start, Date end);

}
