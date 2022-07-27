package com.xumak.metrics.webapp.controller;

import com.xumak.metrics.model.dto.AppResponse;
import com.xumak.metrics.model.dto.PersonResolutionDTO;
import com.xumak.metrics.service.IMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("person-resolution-metrics")
public class PersonResolutionController {
    
    @Autowired
    IMetricService<PersonResolutionDTO> service;

    @PostMapping
    public AppResponse persistPersonResolutionService(@RequestBody PersonResolutionDTO personResolutionDTO ) {
        return  service.persist(personResolutionDTO);
    }

    @GetMapping("/{id}")
    public PersonResolutionDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<PersonResolutionDTO> getByTimestamp(@RequestParam("start")
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                Date start,
                                                    @RequestParam
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                            Date end) {
        return service.getByTimestamps(start, end);
    }


}
