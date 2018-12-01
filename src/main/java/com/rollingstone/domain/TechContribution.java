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

@SqlResultSetMapping(name = "professionalExperienceTechContributionPartialMapping", classes = {
		@ConstructorResult(targetClass = TechContributionDTO.class, columns  = {
				@ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "tech_controbution_made"),
				@ColumnResult(name = "employer_name"),
				@ColumnResult(name = "employer_id", type = Long.class),
		})
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "ProfessionalExeprienceTechContributionRepository.getTechContributionByID",
			query = "SELECT b.id, b.tech_controbution_made, a.employer_name, a.id employer_id "
			+ " FROM professional_experience a,  professional_experience_tech_contribution b WHERE a.id = b.prof_exp_id and a.id = :id", 
			resultSetMapping = "professionalExperienceTechContributionPartialMapping" )
})
@Entity
@Table(name = "professional_experience_tech_contribution")
public class TechContribution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "tech_controbution_made")
	private String techContributionMade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prof_exp_id", nullable = false)
	ProfessionalExperience professionalExperience;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTechContributionMade() {
		return techContributionMade;
	}

	public void setTechContributionMade(String techContributionMade) {
		this.techContributionMade = techContributionMade;
	}

	public ProfessionalExperience getProfessionalExperience() {
		return professionalExperience;
	}

	public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
		this.professionalExperience = professionalExperience;
	}

	public TechContribution(Long id, String techContributionMade, ProfessionalExperience professionalExperience) {
		super();
		this.id = id;
		this.techContributionMade = techContributionMade;
		this.professionalExperience = professionalExperience;
	}

	public TechContribution() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((professionalExperience == null) ? 0 : professionalExperience.hashCode());
		result = prime * result + ((techContributionMade == null) ? 0 : techContributionMade.hashCode());
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
		TechContribution other = (TechContribution) obj;
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
		if (techContributionMade == null) {
			if (other.techContributionMade != null)
				return false;
		} else if (!techContributionMade.equals(other.techContributionMade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TechContribution [id=" + id + ", techContributionMade=" + techContributionMade
				+ ", professionalExperience=" + professionalExperience + "]";
	}
	
	
}
