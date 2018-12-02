package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "degree_name")
	private String degreName;
	
	@Column(name = "college_name")
	private String collegeName;
	
	@Column(name = "university_name")
	private String universityName;
	
	@Column(name = "year_started")
	private int yearStarted;
	
	@Column(name = "year_completed")
	private int yearCompleted;
	
	@Column(name = "gpa")
	private double gpa;
	
	@Column(name = "is_vendor_certification")
	private boolean isIndustryVendorCertification;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDegreName() {
		return degreName;
	}

	public void setDegreName(String degreName) {
		this.degreName = degreName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public int getYearStarted() {
		return yearStarted;
	}

	public void setYearStarted(int yearStarted) {
		this.yearStarted = yearStarted;
	}

	public int getYearCompleted() {
		return yearCompleted;
	}

	public void setYearCompleted(int yearCompleted) {
		this.yearCompleted = yearCompleted;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public boolean isIndustryVendorCertification() {
		return isIndustryVendorCertification;
	}

	public void setIndustryVendorCertification(boolean isIndustryVendorCertification) {
		this.isIndustryVendorCertification = isIndustryVendorCertification;
	}

	public Education(Long id, String degreName, String collegeName, String universityName, int yearStarted,
			int yearCompleted, double gpa, boolean isIndustryVendorCertification) {
		super();
		this.id = id;
		this.degreName = degreName;
		this.collegeName = collegeName;
		this.universityName = universityName;
		this.yearStarted = yearStarted;
		this.yearCompleted = yearCompleted;
		this.gpa = gpa;
		this.isIndustryVendorCertification = isIndustryVendorCertification;
	}
	
	

	public Education() {
		super();
	}

	@Override
	public String toString() {
		return "Education [id=" + id + ", degreName=" + degreName + ", collegeName=" + collegeName + ", universityName="
				+ universityName + ", yearStarted=" + yearStarted + ", yearCompleted=" + yearCompleted + ", gpa=" + gpa
				+ ", isIndustryVendorCertification=" + isIndustryVendorCertification + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collegeName == null) ? 0 : collegeName.hashCode());
		result = prime * result + ((degreName == null) ? 0 : degreName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isIndustryVendorCertification ? 1231 : 1237);
		result = prime * result + ((universityName == null) ? 0 : universityName.hashCode());
		result = prime * result + yearCompleted;
		result = prime * result + yearStarted;
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
		Education other = (Education) obj;
		if (collegeName == null) {
			if (other.collegeName != null)
				return false;
		} else if (!collegeName.equals(other.collegeName))
			return false;
		if (degreName == null) {
			if (other.degreName != null)
				return false;
		} else if (!degreName.equals(other.degreName))
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isIndustryVendorCertification != other.isIndustryVendorCertification)
			return false;
		if (universityName == null) {
			if (other.universityName != null)
				return false;
		} else if (!universityName.equals(other.universityName))
			return false;
		if (yearCompleted != other.yearCompleted)
			return false;
		if (yearStarted != other.yearStarted)
			return false;
		return true;
	}

	
	
}
