package com.xumak.metrics.dao;


import com.xumak.metrics.model.dto.PersonResolutionDTO;

import java.util.Date;
import java.util.List;

public interface PersonResolutionDAO {

    PersonResolutionDTO getById(Long id);

    List<PersonResolutionDTO> getByTimestamp(Date start, Date end);

    Boolean save(PersonResolutionDTO personResolutionDTO);}
