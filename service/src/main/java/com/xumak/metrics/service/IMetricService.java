package com.xumak.metrics.service;

import com.xumak.metrics.model.dto.AppResponse;

import java.util.Date;
import java.util.List;

public interface IMetricService<T> {

    AppResponse persist(T dto);

    T getById(Long id);

    List<T> getByTimestamps(Date start, Date end);
}
