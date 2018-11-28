package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "career_summary")
public class CareerSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "career_summary_description")
	private String careerSummaryDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCareerSummaryDescription() {
		return careerSummaryDescription;
	}

	public void setCareerSummaryDescription(String careerSummaryDescription) {
		this.careerSummaryDescription = careerSummaryDescription;
	}

	public CareerSummary(long id, String careerSummaryDescription) {
		super();
		this.id = id;
		this.careerSummaryDescription = careerSummaryDescription;
	}

	public CareerSummary() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((careerSummaryDescription == null) ? 0 : careerSummaryDescription.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		CareerSummary other = (CareerSummary) obj;
		if (careerSummaryDescription == null) {
			if (other.careerSummaryDescription != null)
				return false;
		} else if (!careerSummaryDescription.equals(other.careerSummaryDescription))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CareerSummary [id=" + id + ", careerSummaryDescription=" + careerSummaryDescription + "]";
	}
	
	
}
