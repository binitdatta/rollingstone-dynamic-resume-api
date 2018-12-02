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

import com.rollingstone.domain.Skill;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.service.SkillService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("binitdatta/dynamicresume/api")
public class SkillController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(SkillController.class);
	
	private SkillService skillService;
	
	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}
	
	@GetMapping("/skill")
	@ResponseBody
	public List<Skill> getAllSkills() {
 
		List<Skill> skills = new ArrayList<>();
		
		return skillService.getAllSkill();
	}
	
	@GetMapping("/skill/{id}")
	@ResponseBody
	public Skill getSkill(@PathVariable("id") long id) {
 		
		try {
			return skillService.getSkill(id);
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested Skill was not found", new Date(), e);
		}
	}
	
	@PostMapping(value = "/skill")
	@ResponseBody
	public Skill addSkill(@RequestBody Skill skill) {
 
		logger.info("Receved POJO :"+ skill.toString());
		
		Skill _skill = skillService.addSkill(skill);
		return _skill;
	}
	
	@DeleteMapping("/skill/{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		try {
			skillService.deleteSkill(id);
			return new ResponseEntity<>("Skill has been deleted!", HttpStatus.OK);

		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested Skill was not found", new Date(), e);
		}
 
	}
	
	@DeleteMapping("/skill")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Skill...");
 
		skillService.deleteAllSkill();
 
		return new ResponseEntity<>("All Skill have been deleted!", HttpStatus.OK);
	}
	
	@PutMapping("/skill/{id}")
	@ResponseBody
	public Skill updateCustomer(@RequestBody Skill skill) {
 
		try {
			Skill updatedSkill = skillService.updateSkill(skill);
			return updatedSkill;
		} catch (Exception e) {
			 throw new HTTP404Exception("The Requested Skill was not found", new Date(), e);
		}
			
	}
}
