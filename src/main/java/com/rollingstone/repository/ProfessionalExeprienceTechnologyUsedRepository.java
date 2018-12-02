package com.rollingstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.domain.TechnologyUsed;
import com.rollingstone.domain.TechnologyUsedDTO;

public interface ProfessionalExeprienceTechnologyUsedRepository extends CrudRepository<TechnologyUsed, Long>{


	@Query(name="ProfessionalExeprienceTechnologyUsedRepository.getTechnologyUsedByID", nativeQuery = true)
	List<TechnologyUsedDTO> getTechnologyUsedByID(@Param("id") long id);

}
