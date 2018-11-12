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
@Table(name = "counsellor_applicant_forum")
public class CounsellorForum implements Serializable {

	private Long id;
	private Registration register;
	private String counsellorMessage;
	private Boolean status;
	private ApplicantForum forum;
	private Date date;
	
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
	@JoinColumn(name = "counsellor_registeration_id")
	public Registration getRegister() {
		return register;
	}
	public void setRegister(Registration register) {
		this.register = register;
	}
	
	@Column(name = "counsellor_response")
	public String getCounsellorMessage() {
		return counsellorMessage;
	}
	public void setCounsellorMessage(String counsellorMessage) {
		this.counsellorMessage = counsellorMessage;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_id")
	public ApplicantForum getForum() {
		return forum;
	}
	public void setForum(ApplicantForum forum) {
		this.forum = forum;
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
	
}
