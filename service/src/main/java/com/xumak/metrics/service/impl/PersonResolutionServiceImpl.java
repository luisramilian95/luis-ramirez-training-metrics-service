package com.xumak.metrics.service.impl;

import com.xumak.metrics.dao.PersonResolutionDAO;
import com.xumak.metrics.model.dto.PersonResolutionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xumak.metrics.model.dto.AppResponse;
import com.xumak.metrics.service.IMetricService;
import org.springframework.beans.factory.annotation.Qualifier;


@Service
@Qualifier("PersonResolutionService")
public class PersonResolutionServiceImpl implements IMetricService<PersonResolutionDTO> {

    @Autowired
    PersonResolutionDAO dao;

    @Override
    public AppResponse persist(PersonResolutionDTO dto) {
        AppResponse response =  new AppResponse();
        response.setStatus(dao.save(dto));
        return response;
    }

    @Override
    public PersonResolutionDTO getById(Long id) {
        return dao.getById(id);
    }
}
