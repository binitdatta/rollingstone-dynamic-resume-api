package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rollingstone.controller.CareerSummaryController;
import com.rollingstone.domain.CareerSummary;
import com.rollingstone.repository.CareerSummaryRepository;

@Service
public class CareerSummaryService {

	Logger logger = LoggerFactory.getLogger(CareerSummaryService.class);

	private CareerSummaryRepository careerSummaryRepository;
	
	public CareerSummaryService(CareerSummaryRepository careerSummaryRepository) {
		this.careerSummaryRepository = careerSummaryRepository;
	}
	
	public CareerSummary addCareerSummary(CareerSummary careerSummary) {
		
		logger.info("Receved POJO in Service:"+ careerSummary.toString());

		CareerSummary savedSummary = careerSummaryRepository.save(careerSummary);
		
		return savedSummary;
	}
	
	public List<CareerSummary> getAllCareerSummary(){
		Iterable<CareerSummary> careerSummaryIteraable = careerSummaryRepository.findAll();
		List<CareerSummary> listOfSummaries = new ArrayList<CareerSummary>();
				
		careerSummaryIteraable.forEach(listOfSummaries::add);
		return listOfSummaries;
	}
	
	
	public CareerSummary getCareerSummary(Long id) throws Exception {
	
		
		Optional<CareerSummary> existingCareerSummary = careerSummaryRepository.findById(id);
		 
		if (existingCareerSummary.isPresent()) {
			CareerSummary _careerSummary = existingCareerSummary.get();
		
			return _careerSummary;
		} else {
			throw new Exception("Career Summary Not Found");
		}
	}
	
	public CareerSummary updateCareerSummary(CareerSummary careerSummary) throws Exception {
		Long id = careerSummary.getId();
		
		Optional<CareerSummary> existingCareerSummary = careerSummaryRepository.findById(id);
		 
		if (existingCareerSummary.isPresent()) {
			CareerSummary _careerSummary = existingCareerSummary.get();
			_careerSummary.setCareerSummaryDescription(careerSummary.getCareerSummaryDescription());
		
			return careerSummaryRepository.save(_careerSummary);
		} else {
			throw new Exception("Career Summary Not Found");
		}
	}
	
	public boolean deleteCareerSummary(Long id) throws Exception {
		
		Optional<CareerSummary> existingCareerSummary = careerSummaryRepository.findById(id);

		if (existingCareerSummary.isPresent()) {
			careerSummaryRepository.deleteById(id);
		
			return true;
		} else {
			throw new Exception("Career Summary Not Found");
		}
		
	}
	
	public void deleteAllCareerSummary() {
		careerSummaryRepository.deleteAll();
	}
	
	
}
