package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rollingstone.domain.CareerSummary;
import com.rollingstone.domain.ProfessionalExperience;
import com.rollingstone.repository.ProfessionalExeprienceRepository;

@Service
public class ProfessionalExperienceService {

	Logger logger = LoggerFactory.getLogger(ProfessionalExperienceService.class);

	private ProfessionalExeprienceRepository professionalExeprienceRepository;
	
	public ProfessionalExperienceService(ProfessionalExeprienceRepository professionalExeprienceRepository) {
		this.professionalExeprienceRepository = professionalExeprienceRepository;
	}
	
	public ProfessionalExperience addProfessionalExperience(ProfessionalExperience professionalExperience) {
		
		logger.info("Receved POJO in Service:"+ professionalExperience.toString());

		ProfessionalExperience savedProEx = professionalExeprienceRepository.save(professionalExperience);
		
		return savedProEx;
	}
	
	public List<ProfessionalExperience> getAllProfessionalExperience(){
		Iterable<ProfessionalExperience> proExSummaryIteraable = professionalExeprienceRepository.findAll();
		List<ProfessionalExperience> listOfProEx = new ArrayList<ProfessionalExperience>();
				
		proExSummaryIteraable.forEach(listOfProEx::add);
		return listOfProEx;
	}
	
	
	public ProfessionalExperience getProfessionalExperience(Long id) throws Exception {
	
		
		Optional<ProfessionalExperience> existingProfEx = professionalExeprienceRepository.findById(id);
		 
		if (existingProfEx.isPresent()) {
			ProfessionalExperience _careerProfEx = existingProfEx.get();
		
			return _careerProfEx;
		} else {
			throw new Exception("Career Summary Not Found");
		}
	}
	
	public ProfessionalExperience updateProfessionalExperience(ProfessionalExperience proffEx) throws Exception {
		Long id = proffEx.getId();
		
		Optional<ProfessionalExperience> existingProfEx = professionalExeprienceRepository.findById(id);
		 
		if (existingProfEx.isPresent()) {
			ProfessionalExperience _profEx = existingProfEx.get();
			_profEx.setEmployerName(proffEx.getEmployerName());
		
			return professionalExeprienceRepository.save(_profEx);
		} else {
			throw new Exception("Career Summary Not Found");
		}
	}
	
	public boolean deleteProfessionalExperience(Long id) throws Exception {
		
		Optional<ProfessionalExperience> existingProfEx = professionalExeprienceRepository.findById(id);

		if (existingProfEx.isPresent()) {
			professionalExeprienceRepository.deleteById(id);
		
			return true;
		} else {
			throw new Exception("Career Summary Not Found");
		}
		
	}
	
	public void deleteAllProfessionalExperience() {
		professionalExeprienceRepository.deleteAll();
	}
	
	
}
