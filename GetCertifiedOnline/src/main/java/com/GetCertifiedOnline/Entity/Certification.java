package com.GetCertifiedOnline.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "certificate_table")

public class Certification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int certificationId;
	
	@NotBlank(message="certificationName is mandatory")
	private String certificationName;
	
	@NotBlank(message="certificationDescription should not be blank")
	private String certificationDescription;  
	
	@DecimalMin("100")
	private int examFees;
	
	@NotNull(message = "examDate should not be null")
	private LocalDate examDate;
	
	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public String getCertificationDescription() {
		return certificationDescription;
	}

	public void setCertificationDescription(String certificationDescription) {
		this.certificationDescription = certificationDescription;
	}

	public int getExamFees() {
		return examFees;
	}

	public void setExamFees(int examFees) {
		this.examFees = examFees;
	}

	public LocalDate getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Certification(int certificationId,
			@NotBlank(message = "certificationName is mandatory") String certificationName,
			@NotBlank(message = "certificationDescription should not be blank") String certificationDescription,
			@DecimalMin("100") int examFees, @NotNull(message = "examDate should not be null") LocalDate examDate) {
		super();
		this.certificationId = certificationId;
		this.certificationName = certificationName;
		this.certificationDescription = certificationDescription;
		this.examFees = examFees;
		this.examDate = examDate;
	}

	@Override
	public String toString() {
		return "Certification [certificationId=" + certificationId + ", certificationName=" + certificationName
				+ ", certificationDescription=" + certificationDescription + ", examFees=" + examFees + ", examDate="
				+ examDate + "]";
	}

	public Certification() {
		
	}

}
