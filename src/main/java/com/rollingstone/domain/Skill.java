package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "skill_name")
	private String skillName;
	
	
	@Column(name = "skill_details")
	private String skillDetails;
	
	@Column(name = "business_domain_specific_skill_details")
	private String businessDomainSpecificSkillDetails;
	
	@Column(name = "year_gained")
	private int yearGained;
	
	@Column(name = "num_years")
	private int numYears;
	
	@Column(name = "is_business_domain_skill")
	private boolean isBusinessDomainSkill;

	
	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillDetails() {
		return skillDetails;
	}

	public void setSkillDetails(String skillDetails) {
		this.skillDetails = skillDetails;
	}

	public String getBusinessDomainSpecificSkillDetails() {
		return businessDomainSpecificSkillDetails;
	}

	public void setBusinessDomainSpecificSkillDetails(String businessDomainSpecificSkillDetails) {
		this.businessDomainSpecificSkillDetails = businessDomainSpecificSkillDetails;
	}

	public int getYearGained() {
		return yearGained;
	}

	public void setYearGained(int yearGained) {
		this.yearGained = yearGained;
	}

	public int getNumYears() {
		return numYears;
	}

	public void setNumYears(int numYears) {
		this.numYears = numYears;
	}

	public boolean isBusinessDomainSkill() {
		return isBusinessDomainSkill;
	}

	public void setBusinessDomainSkill(boolean isBusinessDomainSkill) {
		this.isBusinessDomainSkill = isBusinessDomainSkill;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Skill(Long id, String skillName, String skillDetails, String businessDomainSpecificSkillDetails,
			int yearGained, int numYears, boolean isBusinessDomainSkill) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.skillDetails = skillDetails;
		this.businessDomainSpecificSkillDetails = businessDomainSpecificSkillDetails;
		this.yearGained = yearGained;
		this.numYears = numYears;
		this.isBusinessDomainSkill = isBusinessDomainSkill;
	}

	public Skill() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((businessDomainSpecificSkillDetails == null) ? 0 : businessDomainSpecificSkillDetails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isBusinessDomainSkill ? 1231 : 1237);
		result = prime * result + numYears;
		result = prime * result + ((skillDetails == null) ? 0 : skillDetails.hashCode());
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
		result = prime * result + yearGained;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (businessDomainSpecificSkillDetails == null) {
			if (other.businessDomainSpecificSkillDetails != null)
				return false;
		} else if (!businessDomainSpecificSkillDetails.equals(other.businessDomainSpecificSkillDetails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isBusinessDomainSkill != other.isBusinessDomainSkill)
			return false;
		if (numYears != other.numYears)
			return false;
		if (skillDetails == null) {
			if (other.skillDetails != null)
				return false;
		} else if (!skillDetails.equals(other.skillDetails))
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		if (yearGained != other.yearGained)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", skillName=" + skillName + ", skillDetails=" + skillDetails
				+ ", businessDomainSpecificSkillDetails=" + businessDomainSpecificSkillDetails + ", yearGained="
				+ yearGained + ", numYears=" + numYears + ", isBusinessDomainSkill=" + isBusinessDomainSkill + "]";
	}

	
	
	
	
}
