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

import com.rollingstone.domain.Education;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.service.EducationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("binitdatta/dynamicresume/api")
public class EducationController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(EducationController.class);
	
	private EducationService educationService;
	
	public EducationController(EducationService educationService) {
		this.educationService = educationService;
	}
	
	@GetMapping("/education")
	@ResponseBody
	public List<Education> getAllEducation() {
 
		List<Education> educations = new ArrayList<>();
		
		return educationService.getAllEducation();
	}
	
	@GetMapping("/education/{id}")
	@ResponseBody
	public Education getEducation(@PathVariable("id") long id) {
 		
		try {
			return educationService.getEducation(id);
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested Education was not found", new Date(), e);
		}
	}
	
	@PostMapping(value = "/education")
	@ResponseBody
	public Education addEducation(@RequestBody Education education) {
 
		logger.info("Receved POJO :"+ education.toString());
		
		Education _education = educationService.addEducation(education);
		return _education;
	}
	
	@DeleteMapping("/education/{id}")
	public ResponseEntity<String> deleteEducation(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		try {
			educationService.deleteEducation(id);
			return new ResponseEntity<>("Education has been deleted!", HttpStatus.OK);

		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested Education was not found", new Date(), e);
		}
 
	}
	
	@DeleteMapping("/education")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Education...");
 
		educationService.deleteAllEducation();
 
		return new ResponseEntity<>("All Education have been deleted!", HttpStatus.OK);
	}
	
	@PutMapping("/education/{id}")
	@ResponseBody
	public Education updateCustomer(@RequestBody Education education) {
 
		try {
			Education updatedEducation = educationService.updateEducation(education);
			return updatedEducation;
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested Education was not found", new Date(), e);
		}
			
	}
}
