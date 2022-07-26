package com.xumak.metrics.service;

import com.xumak.metrics.model.dto.AppResponse;

public interface IMetricService<T> {

    AppResponse persist(T dto);

    T getById(Long id);
}
