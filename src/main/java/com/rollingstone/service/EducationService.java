package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rollingstone.domain.Education;
import com.rollingstone.repository.EducationRepository;

@Service
public class EducationService {

	Logger logger = LoggerFactory.getLogger(EducationService.class);

	private EducationRepository educationRepository;
	
	public EducationService(EducationRepository educationRepository) {
		this.educationRepository = educationRepository;
	}
	
	public Education addEducation(Education education) {
		
		logger.info("Receved POJO in Service:"+ education.toString());

		Education savedSummary = educationRepository.save(education);
		
		return savedSummary;
	}
	
	public List<Education> getAllEducation(){
		Iterable<Education> educationIteraable = educationRepository.findAll();
		List<Education> listOfSummaries = new ArrayList<Education>();
				
		educationIteraable.forEach(listOfSummaries::add);
		return listOfSummaries;
	}
	
	
	public Education getEducation(Long id) throws Exception {
	
		
		Optional<Education> existingEducation = educationRepository.findById(id);
		 
		if (existingEducation.isPresent()) {
			Education _education = existingEducation.get();
		
			return _education;
		} else {
			throw new Exception("Education Not Found");
		}
	}
	
	public Education updateEducation(Education education) throws Exception {
		Long id = education.getId();
		
		Optional<Education> existingEducation = educationRepository.findById(id);
		 
		if (existingEducation.isPresent()) {
			Education _education = existingEducation.get();
			_education.setCollegeName(education.getCollegeName());
			_education.setDegreName(education.getDegreName());
			_education.setGpa(education.getGpa());
			_education.setIndustryVendorCertification(education.isIndustryVendorCertification());
			_education.setUniversityName(education.getUniversityName());
			_education.setYearCompleted(education.getYearCompleted());
			_education.setYearStarted(education.getYearStarted());
		
			return educationRepository.save(_education);
		} else {
			throw new Exception("Education Not Found Not Found");
		}
	}
	
	public boolean deleteEducation(Long id) throws Exception {
		
		Optional<Education> existingEducation = educationRepository.findById(id);

		if (existingEducation.isPresent()) {
			educationRepository.deleteById(id);
		
			return true;
		} else {
			throw new Exception("Education Not Found Not Found");
		}
		
	}
	
	public void deleteAllEducation() {
		educationRepository.deleteAll();
	}
	
	
}
