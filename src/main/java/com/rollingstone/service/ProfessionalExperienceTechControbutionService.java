package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rollingstone.domain.TechContribution;
import com.rollingstone.domain.TechContributionDTO;
import com.rollingstone.repository.ProfessionalExeprienceTechContributionRepository;

@Service
public class ProfessionalExperienceTechControbutionService {

	Logger logger = LoggerFactory.getLogger(ProfessionalExperienceTechControbutionService.class);

	private ProfessionalExeprienceTechContributionRepository professionalExeprienceTechContributionRepository;

	public ProfessionalExperienceTechControbutionService(
			ProfessionalExeprienceTechContributionRepository professionalExeprienceTechContributionRepository) {
		this.professionalExeprienceTechContributionRepository = professionalExeprienceTechContributionRepository;
	}

	public TechContribution addProfessionalExperienceTechControbution(TechContribution techContribution) {

		logger.info("Receved POJO in Service:" + techContribution.toString());

		TechContribution savedProEx = professionalExeprienceTechContributionRepository.save(techContribution);

		return savedProEx;
	}

	public List<TechContributionDTO> getTechContributionByID(long id) {
		return professionalExeprienceTechContributionRepository.getTechContributionByID(id);
	}

	public List<TechContribution> getAllProfessionalExperienceTechControbution() {
		Iterable<TechContribution> proExSummaryIteraable = professionalExeprienceTechContributionRepository.findAll();
		List<TechContribution> listOfProEx = new ArrayList<TechContribution>();

		proExSummaryIteraable.forEach(listOfProEx::add);
		return listOfProEx;
	}

	public TechContribution getProfessionalExperienceTechContribution(Long id) throws Exception {

		Optional<TechContribution> existingProfEx = professionalExeprienceTechContributionRepository.findById(id);

		if (existingProfEx.isPresent()) {
			TechContribution _careerProfEx = existingProfEx.get();

			return _careerProfEx;
		} else {
			throw new Exception("Career Summary Not Found");
		}
	}

	public TechContribution updateProfessionalExperienceTechContribution(TechContribution proffEx) throws Exception {
		Long id = proffEx.getId();

		Optional<TechContribution> existingProfEx = professionalExeprienceTechContributionRepository.findById(id);

		if (existingProfEx.isPresent()) {
			TechContribution _profEx = existingProfEx.get();
			_profEx.setTechContributionMade(proffEx.getTechContributionMade());

			return professionalExeprienceTechContributionRepository.save(_profEx);
		} else {
			throw new Exception("Career Summary Not Found");
		}
	}

	public boolean deleteProfessionalExperienceTechContribution(Long id) throws Exception {

		Optional<TechContribution> existingProfEx = professionalExeprienceTechContributionRepository.findById(id);

		if (existingProfEx.isPresent()) {
			professionalExeprienceTechContributionRepository.deleteById(id);

			return true;
		} else {
			throw new Exception("Career Summary Not Found");
		}

	}

	public void deleteAllProfessionalExperienceTechControbution() {
		professionalExeprienceTechContributionRepository.deleteAll();
	}

}
