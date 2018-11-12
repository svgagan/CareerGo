package com.albany.career.dto;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CounselorDto implements Serializable {

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String confirmpassword;
	private String address;
	private String gender;
	private String phone;
	private Long roleId;
	private Boolean bStatus;
	private String vStatus;
	private String sDate;
	private Date dDate;
	
	private String message;
	private Long registerId;
	
	private String qualification;
	private MultipartFile photoFile;
	private String photoType;
	private Blob photo;
	private String experience;
	private String description;
	

	public CounselorDto(){
	}
	
	public CounselorDto(Long id,String firstname,String lastname,String email,String address,String gender,String phone,Boolean bStatus,Date dDate,Long roleId){
		this.setId(id);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setAddress(address);
		this.setEmail(email);
		this.setGender(gender);
		this.setPhone(phone);
		this.setbStatus(bStatus);
		this.setdDate(dDate);
		this.setRoleId(roleId);
	}
	
	public CounselorDto(Long id,Long registerId,String message,Boolean bStatus,Date dDate){
		this.setId(id);
		this.setbStatus(bStatus);
		this.setdDate(dDate);
		this.setMessage(message);
		this.setRegisterId(registerId);
	}
	
	public CounselorDto(Long id,Long registerId,String qualification,String experience,String description,Boolean bStatus,Blob photo,String photoType){
		this.setId(id);
		this.setRegisterId(registerId);
		this.setQualification(qualification);
		this.setExperience(experience);
		this.setDescription(description);
		this.setPhoto(photo);
		this.setPhotoType(photoType);
		this.setbStatus(bStatus);
	}
	
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Boolean getbStatus() {
		return bStatus;
	}
	public void setbStatus(Boolean bStatus) {
		this.bStatus = bStatus;
	}
	public String getvStatus() {
		return vStatus;
	}
	public void setvStatus(String vStatus) {
		this.vStatus = vStatus;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
