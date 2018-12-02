package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rollingstone.domain.Skill;
import com.rollingstone.repository.SkillRepository;

@Service
public class SkillService {

	Logger logger = LoggerFactory.getLogger(SkillService.class);

	private SkillRepository skillRepository;
	
	public SkillService(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}
	
	public Skill addSkill(Skill skill) {
		
		logger.info("Receved POJO in Service:"+ skill.toString());

		Skill savedSummary = skillRepository.save(skill);
		
		return savedSummary;
	}
	
	public List<Skill> getAllSkill(){
		Iterable<Skill> skillIteraable = skillRepository.findAll();
		List<Skill> listOfSummaries = new ArrayList<Skill>();
				
		skillIteraable.forEach(listOfSummaries::add);
		return listOfSummaries;
	}
	
	
	public Skill getSkill(Long id) throws Exception {
	
		
		Optional<Skill> existingSkill = skillRepository.findById(id);
		 
		if (existingSkill.isPresent()) {
			Skill _skill = existingSkill.get();
		
			return _skill;
		} else {
			throw new Exception("Skill Not Found");
		}
	}
	
	public Skill updateSkill(Skill skill) throws Exception {
		Long id = skill.getId();
		
		Optional<Skill> existingSkill = skillRepository.findById(id);
		 
		if (existingSkill.isPresent()) {
			Skill _skill = existingSkill.get();
			_skill.setBusinessDomainSkill(skill.isBusinessDomainSkill());
			_skill.setBusinessDomainSpecificSkillDetails(skill.getBusinessDomainSpecificSkillDetails());
			_skill.setNumYears(skill.getNumYears());
			_skill.setYearGained(skill.getYearGained());
			_skill.setSkillDetails(skill.getSkillDetails());
			_skill.setSkillName(skill.getSkillName());
		
			return skillRepository.save(_skill);
		} else {
			throw new Exception("Skill Not Found Not Found");
		}
	}
	
	public boolean deleteSkill(Long id) throws Exception {
		
		Optional<Skill> existingSkill = skillRepository.findById(id);

		if (existingSkill.isPresent()) {
			skillRepository.deleteById(id);
		
			return true;
		} else {
			throw new Exception("Skill Not Found Not Found");
		}
		
	}
	
	public void deleteAllSkill() {
		skillRepository.deleteAll();
	}
	
	
}
