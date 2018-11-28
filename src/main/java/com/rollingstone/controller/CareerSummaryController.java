package com.rollingstone.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.CareerSummary;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.service.CareerSummaryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("binitdatta/dynamicresume/api")
public class CareerSummaryController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(CareerSummaryController.class);
	
	private CareerSummaryService careerSummaryService;
	
	public CareerSummaryController(CareerSummaryService careerSummaryService) {
		this.careerSummaryService = careerSummaryService;
	}
	
	@GetMapping("/careersummary")
	@ResponseBody
	public List<CareerSummary> getAllCareerSummaries() {
 
		List<CareerSummary> careersummaries = new ArrayList<>();
		
		return careerSummaryService.getAllCareerSummary();
	}
	
	@GetMapping("/careersummary/{id}")
	@ResponseBody
	public CareerSummary getCareerSummary(@PathVariable("id") long id) {
 		
		try {
			return careerSummaryService.getCareerSummary(id);
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested CareerSummary was not found", new Date(), e);
		}
	}
	
	@PostMapping(value = "/careersummary")
	@ResponseBody
	public CareerSummary addCareerSummary(@RequestBody CareerSummary careerSummary) {
 
		logger.info("Receved POJO :"+ careerSummary.toString());
		
		CareerSummary _careerSummary = careerSummaryService.addCareerSummary(careerSummary);
		return _careerSummary;
	}
	
	@DeleteMapping("/careersummary/{id}")
	public ResponseEntity<String> deleteCareerSummary(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		try {
			careerSummaryService.deleteCareerSummary(id);
			return new ResponseEntity<>("CareerSummary has been deleted!", HttpStatus.OK);

		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested CareerSummary was not found", new Date(), e);
		}
 
	}
	
	@DeleteMapping("/careersummary")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All CareerSummary...");
 
		careerSummaryService.deleteAllCareerSummary();
 
		return new ResponseEntity<>("All CareerSummary have been deleted!", HttpStatus.OK);
	}
	
	@PutMapping("/careersummary/{id}")
	@ResponseBody
	public CareerSummary updateCustomer(@RequestBody CareerSummary careerSummary) {
 
		try {
			CareerSummary updatedCareerSummary = careerSummaryService.updateCareerSummary(careerSummary);
			return updatedCareerSummary;
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested CareerSummary was not found", new Date(), e);
		}
			
	}
}
