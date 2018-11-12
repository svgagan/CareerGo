package com.albany.career.dto;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CompanyDto implements Serializable {

	private Long id;
	private String companyname;
	private String email;
	private String password;
	private String confirmpassword;
	private String address;
	private String phone;
	private Long roleId;
	private Boolean bStatus;
	private String vStatus;
	private String sDate;
	private Date dDate;
	private String name;
	
	private String website;
	private MultipartFile logoFile;
	private String logoType;
	private Blob logo;
	private String domain;
	private String description;
	private Long registerId;
	
	private String title;
	private String salary;
	private Boolean jobStatus;
	private Long jobTypeId;
	private Date createdDate;
	private String jobType;
	private Long jobId;
	private String companyResponse;
	
	private Long rateId;
	private String comments;
	private Boolean verified;
	private Integer stars;
	private Integer totalStar;
	

	public CompanyDto(){
	}
	
	public CompanyDto(Long id,String companyname,String email,String address,String phone,Boolean bStatus,Date dDate,Long roleId){
		this.setId(id);
		this.setCompanyname(companyname);
		this.setAddress(address);
		this.setEmail(email);
		this.setPhone(phone);
		this.setbStatus(bStatus);
		this.setdDate(dDate);
		this.setRoleId(roleId);
	}
	
	public CompanyDto(Long id,Long registerId,String domain,String website,String description,Boolean bStatus,Blob logo,String logoType){
		this.setId(id);
		this.setRegisterId(registerId);
		this.setDescription(description);
		this.setbStatus(bStatus);
		this.setDomain(domain);
		this.setWebsite(website);
		this.setLogo(logo);
		this.setLogoType(logoType);
	}
	
	public CompanyDto(Long jobId,Long jobTypeId,Long registerId, String title, String description, String address, String salary, String phone, String email, String jobType, Date createdDate, Boolean jobStatus){
		this.setJobId(jobId);
		this.setJobTypeId(jobTypeId);
		this.setRegisterId(registerId);
		this.setTitle(title);
		this.setDescription(description);
		this.setAddress(address);
		this.setSalary(salary);
		this.setPhone(phone);
		this.setEmail(email);
		this.setJobType(jobType);
		this.setCreatedDate(createdDate);
		this.setJobStatus(jobStatus);
	}
	
	public CompanyDto(Long jobId,Long jobTypeId,Long registerId,String companyname, String title, String description, String address, String salary, String phone, String email, String jobType, Date createdDate, Boolean jobStatus){
		this.setJobId(jobId);
		this.setJobTypeId(jobTypeId);
		this.setRegisterId(registerId);
		this.setTitle(title);
		this.setDescription(description);
		this.setAddress(address);
		this.setSalary(salary);
		this.setPhone(phone);
		this.setEmail(email);
		this.setJobType(jobType);
		this.setCreatedDate(createdDate);
		this.setJobStatus(jobStatus);
		this.setCompanyname(companyname);
	}
	
	public CompanyDto(Long jobId,Long jobTypeId,Long registerId,String companyname, String title, String description, String address, String salary, String phone, String email, String jobType, String companyResponse,Date createdDate, Boolean jobStatus){
		this.setJobId(jobId);
		this.setJobTypeId(jobTypeId);//Job Post Id
		this.setRegisterId(registerId);
		this.setTitle(title);
		this.setDescription(description);
		this.setAddress(address);
		this.setSalary(salary);
		this.setPhone(phone);
		this.setEmail(email);
		this.setJobType(jobType);
		this.setCreatedDate(createdDate);
		this.setJobStatus(jobStatus);
		this.setCompanyname(companyname);
		this.setCompanyResponse(companyResponse);
	}
	
	public CompanyDto(Long rateId,Long id, Long registerId,String comments,int stars,Boolean verified,Boolean bStatus){
		this.setRateId(rateId);
		this.setId(id);
		this.setRegisterId(registerId);
		this.setComments(comments);
		this.setStars(stars);
		this.setVerified(verified);
		this.setbStatus(bStatus);
	}
	
	public CompanyDto(Long rateId,Long id, Long registerId,String name,String companyname,String comments,int stars,Boolean verified,Boolean bStatus){
		this.setRateId(rateId);
		this.setId(id);
		this.setRegisterId(registerId);
		this.setComments(comments);
		this.setStars(stars);
		this.setVerified(verified);
		this.setbStatus(bStatus);
		this.setName(name);
		this.setCompanyname(companyname);
	}
	
	public CompanyDto(Long rateId,Long id, Long registerId,String name,String companyname,String companyResponse,String comments,int stars,Boolean verified,Boolean bStatus){
		this.setRateId(rateId);
		this.setId(id);
		this.setRegisterId(registerId);
		this.setComments(comments);
		this.setStars(stars);
		this.setVerified(verified);
		this.setbStatus(bStatus);
		this.setName(name);
		this.setCompanyname(companyname);
		this.setCompanyResponse(companyResponse);
	}
	
	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	public Long getJobId() {
		return jobId;
	}


	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Boolean getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Boolean jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Long getJobTypeId() {
		return jobTypeId;
	}

	public void setJobTypeId(Long jobTypeId) {
		this.jobTypeId = jobTypeId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public MultipartFile getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(MultipartFile logoFile) {
		this.logoFile = logoFile;
	}

	public String getLogoType() {
		return logoType;
	}

	public void setLogoType(String logoType) {
		this.logoType = logoType;
	}

	public Blob getLogo() {
		return logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
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
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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

	public String getCompanyResponse() {
		return companyResponse;
	}

	public void setCompanyResponse(String companyResponse) {
		this.companyResponse = companyResponse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalStar() {
		return totalStar;
	}

	public void setTotalStar(Integer totalStar) {
		this.totalStar = totalStar;
	}
	
	
}
