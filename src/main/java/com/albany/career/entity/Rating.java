package com.albany.career.entity;

import java.io.Serializable;

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
@Table(name = "company_applicant_review")
public class Rating implements Serializable{

	private Long id;
	private Registration company;
	private Registration applicant;
	private String comments;
	private Integer stars;
	private Boolean verified;
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
	@JoinColumn(name = "company_registeration_id")
	public Registration getCompany() {
		return company;
	}
	public void setCompany(Registration company) {
		this.company = company;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "applicant_registeration_id")
	public Registration getApplicant() {
		return applicant;
	}
	public void setApplicant(Registration applicant) {
		this.applicant = applicant;
	}
	
	@Column(name = "comments")
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Column(name = "verified")
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	
	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@Column(name = "stars")
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
}
