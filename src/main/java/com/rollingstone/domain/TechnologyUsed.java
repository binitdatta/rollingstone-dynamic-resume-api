package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SqlResultSetMapping(name = "professionalExperienceTechnologyUsedPartialMapping", classes = {
		@ConstructorResult(targetClass = TechnologyUsedDTO.class, columns  = {
				@ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "technology_used"),
				@ColumnResult(name = "employer_name"),
				@ColumnResult(name = "employer_id", type = Long.class),
		})
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "ProfessionalExeprienceTechnologyUsedRepository.getTechnologyUsedByID",
			query = "SELECT b.id, b.technology_used, a.employer_name, a.id employer_id "
			+ " FROM professional_experience a,  professional_experience_technology_used b WHERE a.id = b.prof_exp_id and a.id = :id", 
			resultSetMapping = "professionalExperienceTechnologyUsedPartialMapping" )
})
@Entity
@Table(name = "professional_experience_technology_used")
public class TechnologyUsed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "technology_used")
	private String technologyUsed;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prof_exp_id", nullable = false)
	ProfessionalExperience professionalExperience;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTechnologyUsed() {
		return technologyUsed;
	}

	public void setTechnologyUsed(String technologyUsed) {
		this.technologyUsed = technologyUsed;
	}

	public ProfessionalExperience getProfessionalExperience() {
		return professionalExperience;
	}

	public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
		this.professionalExperience = professionalExperience;
	}

	public TechnologyUsed(Long id, String technologyUsed, ProfessionalExperience professionalExperience) {
		super();
		this.id = id;
		this.technologyUsed = technologyUsed;
		this.professionalExperience = professionalExperience;
	}

	public TechnologyUsed() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((professionalExperience == null) ? 0 : professionalExperience.hashCode());
		result = prime * result + ((technologyUsed == null) ? 0 : technologyUsed.hashCode());
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
		TechnologyUsed other = (TechnologyUsed) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (professionalExperience == null) {
			if (other.professionalExperience != null)
				return false;
		} else if (!professionalExperience.equals(other.professionalExperience))
			return false;
		if (technologyUsed == null) {
			if (other.technologyUsed != null)
				return false;
		} else if (!technologyUsed.equals(other.technologyUsed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TechnologyUsed [id=" + id + ", technologyUsed=" + technologyUsed + ", professionalExperience="
				+ professionalExperience + "]";
	}

	
	
}
