package com.vmcms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "vaccination_details")
public class VaccinationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "citizen_name")
	private String citizenName;
	@Column(name = "email")
	private String email;

	@Column(name = "aadhar_no")
	private String aadharNo;

	@Column(name = "city")
	private String city;
	@Column(name = "gender")
	private String gender;
	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "vaccine_name1")
	private String vaccineName1;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "vaccination_date1")
	private Date vaccinationDate1;
	@Column(name = "vaccination_status1")
	private String vaccinationStatus1;

	@Column(name = "vaccine_name2")
	private String vaccineName2;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "vaccination_date2")
	private Date vaccinationDate2;
	@Column(name = "vaccination_status2")
	private String vaccinationStatus2;

	@Column(name = "no_of_vaccine")
	private Integer noOfvaccine;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getVaccineName1() {
		return vaccineName1;
	}

	public void setVaccineName1(String vaccineName1) {
		this.vaccineName1 = vaccineName1;
	}

	public Date getVaccinationDate1() {
		return vaccinationDate1;
	}

	public void setVaccinationDate1(Date vaccinationDate1) {
		this.vaccinationDate1 = vaccinationDate1;
	}

	public String getVaccinationStatus1() {
		return vaccinationStatus1;
	}

	public void setVaccinationStatus1(String vaccinationStatus1) {
		this.vaccinationStatus1 = vaccinationStatus1;
	}

	public String getVaccineName2() {
		return vaccineName2;
	}

	public void setVaccineName2(String vaccineName2) {
		this.vaccineName2 = vaccineName2;
	}

	public Date getVaccinationDate2() {
		return vaccinationDate2;
	}

	public void setVaccinationDate2(Date vaccinationDate2) {
		this.vaccinationDate2 = vaccinationDate2;
	}

	public String getVaccinationStatus2() {
		return vaccinationStatus2;
	}

	public void setVaccinationStatus2(String vaccinationStatus2) {
		this.vaccinationStatus2 = vaccinationStatus2;
	}

	public Integer getNoOfvaccine() {
		return noOfvaccine;
	}

	public void setNoOfvaccine(Integer noOfvaccine) {
		this.noOfvaccine = noOfvaccine;
	}

	@Override
	public String toString() {
		return "VaccinationDetails [id=" + id + ", citizenName=" + citizenName + ", email=" + email + ", aadharNo="
				+ aadharNo + ", city=" + city + ", gender=" + gender + ", mobileNo=" + mobileNo + ", vaccineName1="
				+ vaccineName1 + ", vaccinationDate1=" + vaccinationDate1 + ", vaccinationStatus1=" + vaccinationStatus1
				+ ", vaccineName2=" + vaccineName2 + ", vaccinationDate2=" + vaccinationDate2 + ", vaccinationStatus2="
				+ vaccinationStatus2 + ", noOfvaccine=" + noOfvaccine + "]";
	}

}
