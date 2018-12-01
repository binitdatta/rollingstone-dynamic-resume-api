package com.rollingstone.domain;



public class TechContributionDTO {


	private Long id;
	
	private String techContributionMade;
	
	private String employerName;
	
	private Long employerId;

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

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public TechContributionDTO(Long id, String techContributionMade, String employerName, Long employerId) {
		super();
		this.id = id;
		this.techContributionMade = techContributionMade;
		this.employerName = employerName;
		this.employerId = employerId;
	}

	public TechContributionDTO() {
		super();
	}

	@Override
	public String toString() {
		return "TechContributionDTO [id=" + id + ", techContributionMade=" + techContributionMade + ", employerName="
				+ employerName + ", employerId=" + employerId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employerId == null) ? 0 : employerId.hashCode());
		result = prime * result + ((employerName == null) ? 0 : employerName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TechContributionDTO other = (TechContributionDTO) obj;
		if (employerId == null) {
			if (other.employerId != null)
				return false;
		} else if (!employerId.equals(other.employerId))
			return false;
		if (employerName == null) {
			if (other.employerName != null)
				return false;
		} else if (!employerName.equals(other.employerName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (techContributionMade == null) {
			if (other.techContributionMade != null)
				return false;
		} else if (!techContributionMade.equals(other.techContributionMade))
			return false;
		return true;
	}
	
	

	
	
}
