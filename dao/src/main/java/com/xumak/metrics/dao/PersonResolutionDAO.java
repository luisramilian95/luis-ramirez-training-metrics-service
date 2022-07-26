package com.xumak.metrics.dao;

import com.xumak.metrics.model.PersonResolution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonResolutionDAO extends CrudRepository<PersonResolution, Long> {

}
