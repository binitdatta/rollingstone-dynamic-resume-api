package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rollingstone.domain.TechnologyUsed;
import com.rollingstone.domain.TechnologyUsedDTO;
import com.rollingstone.repository.ProfessionalExeprienceTechnologyUsedRepository;

@Service
public class ProfessionalExperienceTechnologyUsedService {

	Logger logger = LoggerFactory.getLogger(ProfessionalExperienceTechnologyUsedService.class);

	private ProfessionalExeprienceTechnologyUsedRepository professionalExeprienceTechnologyUsedRepository;

	public ProfessionalExperienceTechnologyUsedService(
			ProfessionalExeprienceTechnologyUsedRepository professionalExeprienceTechnologyUsedRepository) {
		this.professionalExeprienceTechnologyUsedRepository = professionalExeprienceTechnologyUsedRepository;
	}

	public TechnologyUsed addProfessionalExperienceTechnologyUsed(TechnologyUsed techContribution) {

		logger.info("Receved POJO in Service:" + techContribution.toString());

		TechnologyUsed savedProEx = professionalExeprienceTechnologyUsedRepository.save(techContribution);

		return savedProEx;
	}

	public List<TechnologyUsedDTO> getTechnologyUsedByID(long id) {
		try {
			return professionalExeprienceTechnologyUsedRepository.getTechnologyUsedByID(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TechnologyUsed> getAllProfessionalExperienceTechnologyUsed() {
		Iterable<TechnologyUsed> proExTechUsedIteraable = professionalExeprienceTechnologyUsedRepository.findAll();
		List<TechnologyUsed> listOfProExTechUsed = new ArrayList<TechnologyUsed>();

		proExTechUsedIteraable.forEach(listOfProExTechUsed::add);
		return listOfProExTechUsed;
	}

	public TechnologyUsed getProfessionalExperienceTechnologyUsed(Long id) throws Exception {

		Optional<TechnologyUsed> existingProfEx = professionalExeprienceTechnologyUsedRepository.findById(id);

		if (existingProfEx.isPresent()) {
			TechnologyUsed _careerProfEx = existingProfEx.get();

			return _careerProfEx;
		} else {
			throw new Exception("Professional Exeprience Technology Used Not Found");
		}
	}

	public TechnologyUsed updateProfessionalExperienceTechnologyUsed(TechnologyUsed proffEx) throws Exception {
		Long id = proffEx.getId();

		Optional<TechnologyUsed> existingProfEx = professionalExeprienceTechnologyUsedRepository.findById(id);

		if (existingProfEx.isPresent()) {
			TechnologyUsed _profEx = existingProfEx.get();
			_profEx.setTechnologyUsed(proffEx.getTechnologyUsed());

			return professionalExeprienceTechnologyUsedRepository.save(_profEx);
		} else {
			throw new Exception("Professional Exeprience Technology Used Not Found");
		}
	}

	public boolean deleteProfessionalExperienceTechnologyUsed(Long id) throws Exception {

		Optional<TechnologyUsed> existingProfEx = professionalExeprienceTechnologyUsedRepository.findById(id);

		if (existingProfEx.isPresent()) {
			professionalExeprienceTechnologyUsedRepository.deleteById(id);

			return true;
		} else {
			throw new Exception("Professional Exeprience Technology Used Not Found");
		}

	}

	public void deleteAllProfessionalExperienceTechnologyUsed() {
		professionalExeprienceTechnologyUsedRepository.deleteAll();
	}

}
