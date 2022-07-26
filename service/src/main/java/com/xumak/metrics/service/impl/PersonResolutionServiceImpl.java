package com.xumak.metrics.service.impl;

import com.xumak.metrics.service.IPersonResolutionService;
import com.xumak.metrics.dao.PersonResolutionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonResolutionServiceImpl implements IPersonResolutionService {

    @Autowired
    PersonResolutionDAO dao;

}
