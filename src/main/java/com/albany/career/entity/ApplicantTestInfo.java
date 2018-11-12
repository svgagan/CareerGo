package com.albany.career.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicant_test_info")
public class ApplicantTestInfo {

	private Long id;
	private Registration register;
	private TestInfo test;
	private Date date;
	private Boolean status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "applicant_registeration_id")
	public Registration getRegister() {
		return register;
	}
	public void setRegister(Registration register) {
		this.register = register;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_info_id")
	public TestInfo getTest() {
		return test;
	}
	public void setTest(TestInfo test) {
		this.test = test;
	}
	
	@Column(name = "date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public ApplicantTestInfo(){
		
	}
	
	public ApplicantTestInfo(Long id, Date date){
		this.setId(id);
		this.setDate(date);
	}
}
