package com.albany.career.entity;

import java.io.Serializable;
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
@Table(name = "applicant_test_marks_info")
public class ApplicantGrade implements Serializable {

	private Long id;
	private Registration register;
	private ApplicantTestInfo testInfo;
	private Boolean status;
	private String url;
	private Date date;
	private String marks;
	
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
	@JoinColumn(name = "applicant_test_info_id")
	public ApplicantTestInfo getTestInfo() {
		return testInfo;
	}
	public void setTestInfo(ApplicantTestInfo testInfo) {
		this.testInfo = testInfo;
	}
	
	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@Column(name = "file_url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name = "date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "marks")
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	public ApplicantGrade(){
		
	}
	
	public ApplicantGrade(Long id,Date date,String marks){
		this.setMarks(marks);
		this.setId(id);
		this.setDate(date);
	}
}
