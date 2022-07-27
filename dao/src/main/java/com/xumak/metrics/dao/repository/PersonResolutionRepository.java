package com.xumak.metrics.dao.repository;

import com.xumak.metrics.model.PersonResolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonResolutionRepository extends JpaRepository<PersonResolution, Long> {

}
