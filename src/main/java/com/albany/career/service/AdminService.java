package com.albany.career.service;

import java.util.List;

import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.Registration;
import com.albany.career.entity.TestInfo;
import com.albany.career.utility.FunctionResponse;

public interface AdminService {

	List<ApplicantDto> getApplicantList();

	List<CompanyDto> getCompanyList();

	List<CounselorDto> getCounselorList();

	KeyValueDto getAdminDetails(Long id, Long roleId);

	List<KeyValueDto> getTestList();

	Registration getRegistratioDetails(Long rId);

	Boolean saveTestDetails(TestInfo test);

	TestInfo getTestInfo(Long testId);

	FunctionResponse saveProfile(Registration newRegister);

	List<KeyValueDto> getTestInfoToGrade();

	List<CompanyDto> getAbusiveReviewList();



}
