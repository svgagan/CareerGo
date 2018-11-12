package com.albany.career.dto;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class KeyValueDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String confirmpassword;
	private String location;
	private String gender;
	private String phone;
	private String companyName;
	private Long roleId;
	private Boolean verified;
	private String vStatus;
	private Date date;
	private String sDate;
	private String fullname;
	
	private String testname;
	private String testtype;
	private Blob testfile;
	private Long registerId;
	private Boolean status;
	private MultipartFile testFile;
	private Long testId;
	private String marks;
	private String url;
	private Long hits;
	private Integer stars;

	public KeyValueDto(){
	}
	
	public KeyValueDto(Long id,String email,String password){
		this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
	}
	
	public KeyValueDto(String email,String password){
		this.setEmail(email);
		this.setPassword(password);
	}
	
	public KeyValueDto(Long id,String fName,String email,String password){
		this.id = id;
		this.fName = fName;
		this.email = email;
		this.password = password;
	}
	
	public KeyValueDto(Long id,String email,String password,Long roleId){
		this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
		this.setRoleId(roleId);
	}
	
	public KeyValueDto(Long id,String fName,String lName,String email,String phone,String location,String gender,Boolean verified,Date date,Long roleId){
		this.setId(id);
		this.setfName(fName);
		this.setlName(lName);
		this.setEmail(email);
		this.setLocation(location);
		this.setPhone(phone);
		this.setGender(gender);
		this.setVerified(verified);
		this.setDate(date);
		this.setRoleId(roleId);
	}
	
	public KeyValueDto(Long id,String testname,String testtype,Date date,Boolean status,Long registerId){
		this.setId(id);
		this.setTestname(testname);
		this.setTesttype(testtype);
		this.setDate(date);
		this.setStatus(status);
		this.setRegisterId(registerId);
	}
	
	public KeyValueDto(Long id,Long registerId, Long testId,String testname ,Boolean status, Date date){
		this.setId(id);
		this.setRegisterId(registerId);
		this.setTestId(testId);
		this.setStatus(status);
		this.setTestname(testname);
		this.setDate(date);
	}
	
	public KeyValueDto(Long id,Long registerId,Long testId,String testname,String fName,String lName,String url,String marks,Boolean status,Date date){
		this.setId(id);
		this.setRegisterId(registerId);
		this.setTestId(testId);
		this.setUrl(url);
		this.setMarks(marks);
		this.setStatus(status);
		this.setTestname(testname);
		this.setfName(fName);
		this.setlName(lName);
		this.setDate(date);
	}
	
	public KeyValueDto(Long id,String fName,String lName,String email,String phone,String location,String gender,Boolean verified,Date date,Long roleId,Long hits){
		this.setId(id);
		this.setfName(fName);
		this.setlName(lName);
		this.setEmail(email);
		this.setLocation(location);
		this.setPhone(phone);
		this.setGender(gender);
		this.setVerified(verified);
		this.setDate(date);
		this.setRoleId(roleId);
		this.setHits(hits);
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public String getTesttype() {
		return testtype;
	}

	public void setTesttype(String testtype) {
		this.testtype = testtype;
	}

	public Blob getTestfile() {
		return testfile;
	}

	public void setTestfile(Blob testfile) {
		this.testfile = testfile;
	}

	public Long getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}
	
	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public String getvStatus() {
		return vStatus;
	}

	public void setvStatus(String vStatus) {
		this.vStatus = vStatus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
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

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public MultipartFile getTestFile() {
		return testFile;
	}

	public void setTestFile(MultipartFile testFile) {
		this.testFile = testFile;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}
	

}
