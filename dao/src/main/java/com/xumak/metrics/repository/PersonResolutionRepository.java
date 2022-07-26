package com.xumak.metrics.repository;

import com.xumak.metrics.model.PersonResolution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonResolutionRepository extends CrudRepository<PersonResolution, Long> {

}
