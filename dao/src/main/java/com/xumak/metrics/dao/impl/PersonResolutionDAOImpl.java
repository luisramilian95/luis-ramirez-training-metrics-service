package com.xumak.metrics.dao.impl;

import com.xumak.metrics.dao.PersonResolutionDAO;
import com.xumak.metrics.mapper.PersonResolutionMapper;
import com.xumak.metrics.model.PersonResolution;
import com.xumak.metrics.model.dto.PersonResolutionDTO;
import com.xumak.metrics.repository.PersonResolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public class PersonResolutionDAOImpl implements PersonResolutionDAO {

    @Autowired
    PersonResolutionRepository repository;

    @Autowired
    PersonResolutionMapper mapper;

    @Override
    public PersonResolutionDTO getById(Long id) {
        Optional<PersonResolution> personResolution = repository.findById(id);
        return mapper.toPersonResolutionDTO(personResolution.orElse(null));
    }

    @Override
    public List<PersonResolutionDTO> getByTimestamp(Date start, Date end) {
        return null;
    }

    @Override
    public Boolean save(PersonResolutionDTO personResolutionDTO) {
        PersonResolution personResolution = mapper.toPersonResolution(personResolutionDTO);
        repository.save(personResolution);
        return true;
    }
}
