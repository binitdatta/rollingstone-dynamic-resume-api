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

import com.rollingstone.domain.ProfessionalExperience;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.service.ProfessionalExperienceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("binitdatta/dynamicresume/api")
public class ProfessionalExperienceController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(ProfessionalExperienceController.class);
	
	private ProfessionalExperienceService professionalExperienceService;
	
	public ProfessionalExperienceController(ProfessionalExperienceService professionalExperienceService) {
		this.professionalExperienceService = professionalExperienceService;
	}
	
	@GetMapping("/professionalexperience")
	@ResponseBody
	public List<ProfessionalExperience> getAllCareerSummaries() {
 		
		return professionalExperienceService.getAllProfessionalExperience();
	}
	
	@GetMapping("/professionalexperience/{id}")
	@ResponseBody
	public ProfessionalExperience getProfessionalExperience(@PathVariable("id") long id) {
 		
		try {
			return professionalExperienceService.getProfessionalExperience(id);
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience was not found", new Date(), e);
		}
	}
	
	@PostMapping(value = "/professionalexperience")
	@ResponseBody
	public ProfessionalExperience addProfessionalExperience(@RequestBody ProfessionalExperience professionalExperience) {
 
		logger.info("Receved POJO :"+ professionalExperience.toString());
		
		ProfessionalExperience _professionalExperience = professionalExperienceService.addProfessionalExperience(professionalExperience);
		return _professionalExperience;
	}
	
	@DeleteMapping("/professionalexperience/{id}")
	public ResponseEntity<String> deleteProfessionalExperience(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		try {
			professionalExperienceService.deleteProfessionalExperience(id);
			return new ResponseEntity<>("ProfessionalExperience has been deleted!", HttpStatus.OK);

		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience was not found", new Date(), e);
		}
 
	}
	
	@DeleteMapping("/professionalexperience")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All ProfessionalExperience...");
 
		professionalExperienceService.deleteAllProfessionalExperience();
 
		return new ResponseEntity<>("All ProfessionalExperience have been deleted!", HttpStatus.OK);
	}
	
	@PutMapping("/professionalexperience/{id}")
	@ResponseBody
	public ProfessionalExperience updateCustomer(@RequestBody ProfessionalExperience professionalExperience) {
 
		try {
			ProfessionalExperience updatedProfessionalExperience = professionalExperienceService.updateProfessionalExperience(professionalExperience);
			return updatedProfessionalExperience;
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience was not found", new Date(), e);
		}
			
	}
}
