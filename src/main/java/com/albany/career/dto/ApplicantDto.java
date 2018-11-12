package com.albany.career.dto;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ApplicantDto implements Serializable {
	
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
	private String name;
	
	private Long degreeId;
	private String degreeName;
	private Long majorId;
	private String majorName;
	private String school;
	private Date startDate;
	private String startdate;
	private Date endDate;
	private String enddate;
	private Long educationId;
	private Long registerId;
	private Boolean educationStatus;
	
	private String skills;
	private Boolean status;
	
	private String certificate;
	private String authority;
	
	private Long projectId;
	private String title;
	private String description;
	private String teams;
	private String url;
	
	private String position;
	private String company;
	
	private String docName;
	private MultipartFile docFile;
	private String docType;
	private Blob docfile;
	private Long docId;
	private Long docTypeId;
	
	private String message;
	private String subject;
	private Boolean responseStatus;
	private Long forumId;
	private String response;
	private String marks;
	
	private Long jobId;
	private Long jobPostId;
	private String companyResponse;
	
	
	public ApplicantDto(Long jobId,Long jobPostId,Long registerId,String companyResponse,Boolean status,Date dDate){
		this.setJobId(jobId);
		this.setJobPostId(jobPostId);
		this.setRegisterId(registerId);
		this.setCompanyResponse(companyResponse);
		this.setStatus(status);
		this.setdDate(dDate);
	}

	public ApplicantDto(){
	}
	
	public ApplicantDto(Long id,String skills,Boolean status,Long registerId){
		this.setId(id);
		this.setSkills(skills);
		this.setStatus(status);
		this.setRegisterId(registerId);
	}
	
	public ApplicantDto(Long id,String firstname,String lastname,String email,String address,String gender,String phone,Boolean bStatus,Date dDate,Long roleId){
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
	
	public ApplicantDto(Long educationId,String degreeName,String majorName,String school,Date startDate,Date endDate,Long registerId,Boolean educationStatus,Long degreeId,Long majorId){
		this.setEducationId(educationId);
		this.setDegreeName(degreeName);
		this.setMajorName(majorName);
		this.setSchool(school);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setRegisterId(registerId);
		this.setEducationStatus(educationStatus);
		this.setMajorId(majorId);
		this.setDegreeId(degreeId);
	}
	
	public ApplicantDto(Long id,String certificate,String authority,Date startDate,Date endDate,Long registerId,Boolean status){
		this.setId(id);
		this.setCertificate(certificate);
		this.setAuthority(authority);
		this.setStatus(status);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setRegisterId(registerId);
	}
	
	public ApplicantDto(Long projectId,String title,String description,String teams,String url,Date startDate,Date endDate,Long registerId,Boolean status){
		this.setProjectId(projectId);
		this.setTitle(title);
		this.setDescription(description);
		this.setTeams(teams);
		this.setUrl(url);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setStatus(status);
		this.setRegisterId(registerId);
	}
	
	public ApplicantDto(Long id,Long registerId,String position,String company,String description,String address,Date startDate,Date endDate,Boolean status){
		this.setId(id);
		this.setPosition(position);
		this.setCompany(company);
		this.setAddress(address);
		this.setDescription(description);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setStatus(status);
		this.setRegisterId(registerId);
	}
	
	public ApplicantDto(Long docId,Long registerId,String docName,String docType,Boolean status,Long docTypeId,String position){
		this.setDocId(docId);
		this.setRegisterId(registerId);
		this.setDocName(docName);
		this.setDocType(docType);
		this.setStatus(status);
		this.setDocTypeId(docTypeId);
		this.setPosition(position);
	}
	
	public ApplicantDto(Long forumId,Long registerId,String subject,String message,Boolean status,Boolean responseStatus,Date dDate){
		this.setForumId(forumId);
		this.setSubject(subject);
		this.setMessage(message);
		this.setResponseStatus(responseStatus);
		this.setdDate(dDate);
		this.setStatus(status);
		this.setRegisterId(registerId);
	}
	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(Long jobPostId) {
		this.jobPostId = jobPostId;
	}

	public String getCompanyResponse() {
		return companyResponse;
	}

	public void setCompanyResponse(String companyResponse) {
		this.companyResponse = companyResponse;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Boolean getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Boolean responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public MultipartFile getDocFile() {
		return docFile;
	}

	public void setDocFile(MultipartFile docFile) {
		this.docFile = docFile;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public Blob getDocfile() {
		return docfile;
	}

	public void setDocfile(Blob docfile) {
		this.docfile = docfile;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
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
	
	public Long getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(Long degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public Long getMajorId() {
		return majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Long getEducationId() {
		return educationId;
	}

	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}

	public Long getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}

	public Boolean getEducationStatus() {
		return educationStatus;
	}

	public void setEducationStatus(Boolean educationStatus) {
		this.educationStatus = educationStatus;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}


	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTeams() {
		return teams;
	}

	public void setTeams(String teams) {
		this.teams = teams;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getDocTypeId() {
		return docTypeId;
	}

	public void setDocTypeId(Long docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

}
