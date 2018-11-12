package com.albany.career.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applicant_documents_type")
public class DocumentType implements Serializable {

	private Long id;
	private String documentType;
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
	
	@Column(name = "document_type")
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public DocumentType(){
		
	}
	
	public DocumentType(Long id,String documentType){
		this.setId(id);
		this.setDocumentType(documentType);
	}
	
	public DocumentType(Long id,String documentType,Boolean status){
		this.setId(id);
		this.setDocumentType(documentType);
		this.setStatus(status);
	}
	
}
