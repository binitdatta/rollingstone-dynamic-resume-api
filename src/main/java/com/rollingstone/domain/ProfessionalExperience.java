package com.rollingstone.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "professional_experience")
public class ProfessionalExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "employer_name")
	private String employerName;

	@Column(name = "exp_details")
	private String experienceDetails;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professionalExperience")
	@JsonIgnore
	private Set<TechContribution> techContributions = new HashSet<TechContribution>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getExperienceDetails() {
		return experienceDetails;
	}

	public void setExperienceDetails(String experienceDetails) {
		this.experienceDetails = experienceDetails;
	}

	public ProfessionalExperience(Long id, String employerName, String experienceDetails) {
		super();
		this.id = id;
		this.employerName = employerName;
		this.experienceDetails = experienceDetails;
	}

	public ProfessionalExperience() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProfessionalExperience [id=" + id + ", employerName=" + employerName + ", experienceDetails="
				+ experienceDetails + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employerName == null) ? 0 : employerName.hashCode());
		result = prime * result + ((experienceDetails == null) ? 0 : experienceDetails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProfessionalExperience other = (ProfessionalExperience) obj;
		if (employerName == null) {
			if (other.employerName != null)
				return false;
		} else if (!employerName.equals(other.employerName))
			return false;
		if (experienceDetails == null) {
			if (other.experienceDetails != null)
				return false;
		} else if (!experienceDetails.equals(other.experienceDetails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
