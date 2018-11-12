package com.albany.career.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albany.career.dao.AdminDao;
import com.albany.career.dao.ApplicantDao;
import com.albany.career.dao.CompanyDao;
import com.albany.career.dao.CounsellorDao;
import com.albany.career.dao.LoginDao;
import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.Registration;
import com.albany.career.entity.TestInfo;
import com.albany.career.service.AdminService;
import com.albany.career.utility.FunctionResponse;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	ApplicantDao applicantDao;
	
	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	CounsellorDao counsellorDao;

	@Transactional
	public List<ApplicantDto> getApplicantList() {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<ApplicantDto> applicantList = adminDao.getApplicantList();
		for (ApplicantDto applicantDto : applicantList) {
			if(applicantDto.getbStatus()){
				applicantDto.setvStatus("Verified");
			}else{
				applicantDto.setvStatus("Not-Verified");
			}
			
			applicantDto.setsDate(df.format(applicantDto.getdDate()));
		}
		if(applicantList.size() > 0){
			Collections.reverse(applicantList);
		}
		return applicantList;
	}

	@Transactional
	public List<CompanyDto> getCompanyList() {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<CompanyDto> companyList = adminDao.getCompanyList();
		for (CompanyDto companyDto : companyList) {
			if(companyDto.getbStatus()){
				companyDto.setvStatus("Verified");
			}else{
				companyDto.setvStatus("Not-Verified");
			}
			
			companyDto.setsDate(df.format(companyDto.getdDate()));
		}
		if(companyList.size() > 0){
			Collections.reverse(companyList);
		}
		return companyList;
	}

	@Transactional
	public List<CounselorDto> getCounselorList() {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<CounselorDto> counselorList = adminDao.getCounselorList();
		for (CounselorDto counselorDto : counselorList) {
			if(counselorDto.getbStatus()){
				counselorDto.setvStatus("Verified");
			}else{
				counselorDto.setvStatus("Not-Verified");
			}
			
			counselorDto.setsDate(df.format(counselorDto.getdDate()));
		}
		if(counselorList.size() > 0){
			Collections.reverse(counselorList);
		}
		return counselorList;
	}

	@Transactional
	public KeyValueDto getAdminDetails(Long id, Long roleId) {
		// TODO Auto-generated method stub
		KeyValueDto register = adminDao.getRegistrationDetails(id,roleId);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		register.setsDate(df.format(register.getDate()));
		register.setFullname(register.getfName()+" "+register.getlName());
		return register;
	}

	@Transactional
	public List<KeyValueDto> getTestList() {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<KeyValueDto> testList = adminDao.getTestList();
		for (KeyValueDto keyValueDto : testList) {
			keyValueDto.setsDate(df.format(keyValueDto.getDate()));
		}
		if(testList.size() > 0){
			Collections.reverse(testList);
		}
		return testList;
	}

	@Transactional
	public Registration getRegistratioDetails(Long rId) {
		// TODO Auto-generated method stub
		return loginDao.getProfile(rId);
	}

	@Transactional
	public Boolean saveTestDetails(TestInfo test) {
		// TODO Auto-generated method stub
		return adminDao.saveTestDetails(test);
	}

	@Transactional
	public TestInfo getTestInfo(Long testId) {
		// TODO Auto-generated method stub
		return adminDao.getTestInfo(testId);
	}

	@Transactional
	public FunctionResponse saveProfile(Registration newRegister) {
		// TODO Auto-generated method stub
		return loginDao.saveProfileInfo(newRegister);
	}

	@Transactional
	public List<KeyValueDto> getTestInfoToGrade() {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<KeyValueDto> testList = adminDao.getTestInfoToGrade();
		for (KeyValueDto keyValueDto : testList) {
			keyValueDto.setsDate(df.format(keyValueDto.getDate()));
			keyValueDto.setFullname(keyValueDto.getfName()+" "+keyValueDto.getlName());
			if(keyValueDto.getMarks().equalsIgnoreCase("Not-Graded")){
				keyValueDto.setVerified(false);
			}else{
				keyValueDto.setVerified(true);
			}
		}
		if(testList.size() > 0){
			Collections.reverse(testList);
		}
		return testList;
	}

	@Transactional
	public List<CompanyDto> getAbusiveReviewList() {
		List<CompanyDto> review = adminDao.getAbusiveReviewList();
		for (CompanyDto companyDto : review) {
			companyDto.setTitle(companyDto.getName()+" "+companyDto.getCompanyname());//Applicant Name
		}
		if(review.size() > 0){
			Collections.reverse(review);
		}
		return review;
	}

}
