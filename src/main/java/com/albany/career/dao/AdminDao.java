package com.albany.career.dao;

import java.util.List;

import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.CertificationDetails;
import com.albany.career.entity.Registration;
import com.albany.career.entity.TestInfo;

public interface AdminDao {

	List<ApplicantDto> getApplicantList();

	List<CompanyDto> getCompanyList();

	List<CounselorDto> getCounselorList();

	KeyValueDto getRegistrationDetails(Long id, Long roleId);

	List<KeyValueDto> getTestList();

	Registration getRegistrationDetails(Long rId);

	Boolean saveTestDetails(TestInfo test);

	TestInfo getTestInfo(Long testId);

	List<KeyValueDto> getTestInfoToGrade();

	List<CompanyDto> getAbusiveReviewList();


}
