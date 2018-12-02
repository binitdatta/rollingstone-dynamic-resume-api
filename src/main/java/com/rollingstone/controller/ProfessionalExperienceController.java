package com.rollingstone.controller;

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
import com.rollingstone.domain.TechContribution;
import com.rollingstone.domain.TechContributionDTO;
import com.rollingstone.domain.TechnologyUsed;
import com.rollingstone.domain.TechnologyUsedDTO;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.service.ProfessionalExperienceService;
import com.rollingstone.service.ProfessionalExperienceTechControbutionService;
import com.rollingstone.service.ProfessionalExperienceTechnologyUsedService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("binitdatta/dynamicresume/api")
public class ProfessionalExperienceController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(ProfessionalExperienceController.class);
	
	private ProfessionalExperienceService professionalExperienceService;
	private ProfessionalExperienceTechControbutionService professionalExperienceTechControbutionService;
	private ProfessionalExperienceTechnologyUsedService professionalExperienceTechnologyUsedService;


	
	public ProfessionalExperienceController(ProfessionalExperienceService professionalExperienceService, 
			ProfessionalExperienceTechControbutionService professionalExperienceTechControbutionService,
			ProfessionalExperienceTechnologyUsedService  professionalExperienceTechnologyUsedService) {
		this.professionalExperienceService = professionalExperienceService;
		this.professionalExperienceTechControbutionService = professionalExperienceTechControbutionService;
		this.professionalExperienceTechnologyUsedService = professionalExperienceTechnologyUsedService;
	}
	
	@GetMapping("/professionalexperience")
	@ResponseBody
	public List<ProfessionalExperience> getAllProfessionalExperiences() {
 		
		return professionalExperienceService.getAllProfessionalExperience();
	}
	
	@GetMapping("/professionalexperience/techcontribution")
	@ResponseBody
	public List<TechContribution> getAllTechContributions() {
 		
		return professionalExperienceTechControbutionService.getAllProfessionalExperienceTechControbution();
	}
	
	@GetMapping("/professionalexperience/technologyused")
	@ResponseBody
	public List<TechnologyUsed> getAllTechnologyUsed() {
 		
		return professionalExperienceTechnologyUsedService.getAllProfessionalExperienceTechnologyUsed();
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
	
	@GetMapping("/professionalexperience/techcontribution/{id}")
	@ResponseBody
	public List<TechContributionDTO> getProfessionalExperienceTechContribution(@PathVariable("id") long id) {
 		
		try {
			return professionalExperienceTechControbutionService.getTechContributionByID(id);
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience was not found", new Date(), e);
		}
	}
	
	@GetMapping("/professionalexperience/technologyused/{id}")
	@ResponseBody
	public List<TechnologyUsedDTO> getProfessionalExperienceTechnologyUsed(@PathVariable("id") long id) {
 		
		try {
			return professionalExperienceTechnologyUsedService.getTechnologyUsedByID(id);
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
	
	@PostMapping(value = "/professionalexperience/{id}/techcontribution")
	@ResponseBody
	public TechContribution addProfessionalExperienceTechContriibution(@RequestBody TechContribution techContribution) {
 
		logger.info("Receved POJO :"+ techContribution.toString());
		
		TechContribution _professionalExperienceTechContrib = professionalExperienceTechControbutionService.addProfessionalExperienceTechControbution(techContribution);
		return _professionalExperienceTechContrib;
	}
	
	@PostMapping(value = "/professionalexperience/{id}/technologyused")
	@ResponseBody
	public TechnologyUsed addProfessionalExperienceTechnologyUsed(@RequestBody TechnologyUsed technologyUsed) {
 
		logger.info("Receved POJO :"+ technologyUsed.toString());
		
		TechnologyUsed _professionalExperienceTechnologyUsed = professionalExperienceTechnologyUsedService.addProfessionalExperienceTechnologyUsed(technologyUsed);
		return _professionalExperienceTechnologyUsed;
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
	
	@DeleteMapping("/professionalexperience/{id}/techcontribution/{techId}")
	public ResponseEntity<String> deleteProfessionalExperienceTechContribution(@PathVariable("techId") long techId) {
		System.out.println("Delete TechContribution with ID = " + techId + "...");
 
		try {
			professionalExperienceTechControbutionService.deleteProfessionalExperienceTechContribution(techId);
			return new ResponseEntity<>("ProfessionalExperience Tech Contribution has been deleted!", HttpStatus.OK);

		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience Tech Contribution  was not found", new Date(), e);
		}
 
	}
	
	@DeleteMapping("/professionalexperience/{id}/techcnologyused/{techId}")
	public ResponseEntity<String> deleteProfessionalExperienceTechnologyUsed(@PathVariable("techId") long techId) {
		System.out.println("Delete TechContribution with ID = " + techId + "...");
 
		try {
			professionalExperienceTechnologyUsedService.deleteProfessionalExperienceTechnologyUsed(techId);
			return new ResponseEntity<>("ProfessionalExperience TechnologyUsed has been deleted!", HttpStatus.OK);

		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience TechnologyUsed  was not found", new Date(), e);
		}
 
	}
	
	@DeleteMapping("/professionalexperience")
	public ResponseEntity<String> deleteAllProfessionalExperience() {
		System.out.println("Delete All ProfessionalExperience...");
 
		professionalExperienceService.deleteAllProfessionalExperience();
 
		return new ResponseEntity<>("All ProfessionalExperience have been deleted!", HttpStatus.OK);
	}
	
	@PutMapping("/professionalexperience/{id}")
	@ResponseBody
	public ProfessionalExperience updateProfessionalExperience(@RequestBody ProfessionalExperience professionalExperience) {
 
		try {
			ProfessionalExperience updatedProfessionalExperience = professionalExperienceService.updateProfessionalExperience(professionalExperience);
			return updatedProfessionalExperience;
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience was not found", new Date(), e);
		}
			
	}
	
	@PutMapping("/professionalexperience/{id}/techcontribution/{techId}")
	@ResponseBody
	public TechContribution updateProfessionalExperienceTechControbition(@RequestBody TechContribution techContribution) {
 
		try {
			TechContribution updatedProfessionalExperienceTechContribution = professionalExperienceTechControbutionService.updateProfessionalExperienceTechContribution(techContribution);
			return updatedProfessionalExperienceTechContribution;
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience Tech Contribution was not found", new Date(), e);
		}
			
	}
	
	@PutMapping("/professionalexperience/{id}/techcnologyused/{techId}")
	@ResponseBody
	public TechnologyUsed updateProfessionalExperienceTechnologyUsed(@RequestBody TechnologyUsed technologyUsed) {
 
		try {
			TechnologyUsed updatedProfessionalExperienceTechnologyUsed = professionalExperienceTechnologyUsedService.updateProfessionalExperienceTechnologyUsed(technologyUsed);
			return updatedProfessionalExperienceTechnologyUsed;
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested ProfessionalExperience Technology Used was not found", new Date(), e);
		}
			
	}
}
