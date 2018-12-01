package com.rollingstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.domain.TechContribution;
import com.rollingstone.domain.TechContributionDTO;

public interface ProfessionalExeprienceTechContributionRepository extends CrudRepository<TechContribution, Long>{


	@Query(name="ProfessionalExeprienceTechContributionRepository.getTechContributionByID", nativeQuery = true)
	List<TechContributionDTO> getTechContributionByID(@Param("id") long id);

}
