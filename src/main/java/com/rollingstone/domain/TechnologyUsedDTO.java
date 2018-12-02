package com.rollingstone.domain;



public class TechnologyUsedDTO {


	private Long id;
	
	private String technologyUsed;
	
	private String employerName;
	
	private Long employerId;

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

	public TechnologyUsedDTO(Long id, String technologyUsed, String employerName, Long employerId) {
		super();
		this.id = id;
		this.technologyUsed = technologyUsed;
		this.employerName = employerName;
		this.employerId = employerId;
	}

	public TechnologyUsedDTO() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employerId == null) ? 0 : employerId.hashCode());
		result = prime * result + ((employerName == null) ? 0 : employerName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TechnologyUsedDTO other = (TechnologyUsedDTO) obj;
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
		if (technologyUsed == null) {
			if (other.technologyUsed != null)
				return false;
		} else if (!technologyUsed.equals(other.technologyUsed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TechnologyUsedDTO [id=" + id + ", technologyUsed=" + technologyUsed + ", employerName=" + employerName
				+ ", employerId=" + employerId + "]";
	}


	

	
	
}
