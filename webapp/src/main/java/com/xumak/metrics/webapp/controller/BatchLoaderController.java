package com.xumak.metrics.webapp.controller;

import com.xumak.metrics.model.dto.AppResponse;
import com.xumak.metrics.model.dto.BatchLoaderDTO;
import com.xumak.metrics.service.IMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("batch-loader-metrics")
public class BatchLoaderController {

    @Autowired
    IMetricService<BatchLoaderDTO> service;

    @PostMapping
    public AppResponse persistBatchLoader(@RequestBody BatchLoaderDTO batchLoader) {
        return  service.persist(batchLoader);
    }

    @GetMapping("/{id}")
    public BatchLoaderDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @GetMapping
    public List<BatchLoaderDTO> getByTimestamp(@RequestParam("start")
                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                           Date start,
                                               @RequestParam
                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                           Date end) {
        return service.getByTimestamps(start, end);
    }

}
