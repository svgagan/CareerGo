package com.albany.career.service;

import java.util.List;

import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.ApplicantForum;
import com.albany.career.entity.ApplicantGrade;
import com.albany.career.entity.ApplicantTestInfo;
import com.albany.career.entity.CertificationDetails;
import com.albany.career.entity.Degree;
import com.albany.career.entity.DocumentType;
import com.albany.career.entity.DocumentsDetails;
import com.albany.career.entity.EducationDetails;
import com.albany.career.entity.JobsApplied;
import com.albany.career.entity.Major;
import com.albany.career.entity.ProjectDetails;
import com.albany.career.entity.Rating;
import com.albany.career.entity.Registration;
import com.albany.career.entity.SkillsDetails;
import com.albany.career.entity.WorkDetails;
import com.albany.career.utility.FunctionResponse;

public interface ApplicantService {

	KeyValueDto getApplicantDetails(Long id, Long roleId);

	Registration getRegistratioDetails(Long id);

	List<ApplicantDto> getEducationList(Long id);

	List<Major> getMajorList();

	List<Degree> getDegreeList();

	FunctionResponse updateEducation(EducationDetails education);

	Degree getDegree(Long degreeId);

	Major getMajor(Long majorId);

	EducationDetails getEducationDetails(Long eId);

	SkillsDetails getSkillsDetails(Long sID);

	FunctionResponse updateSkills(SkillsDetails skill);

	List<ApplicantDto> getCertificateList(Long id);

	FunctionResponse updateCertificate(CertificationDetails certificates);

	CertificationDetails getCertifcate(Long cId);

	List<ApplicantDto> getProjectsList(Long id);

	FunctionResponse updateProjects(ProjectDetails project);

	ProjectDetails getProject(Long pId);

	FunctionResponse updateProject(ProjectDetails project);

	List<ApplicantDto> getWorkList(Long id);

	FunctionResponse updateWork(WorkDetails working);

	WorkDetails getWork(Long wId);

	List<DocumentType> getDocumentTypes();

	DocumentType getDocumentType(Long docTypeId);

	FunctionResponse saveDocumentDetails(DocumentsDetails documentsDetails);

	List<ApplicantDto> getDoumentsList(Long id);

	DocumentsDetails getDocumentDetails(Long docId);

	List<ApplicantDto> getMessagesList(Long id);

	FunctionResponse saveMessages(ApplicantForum aForum);

	List<ApplicantDto> getMessagesList();

	ApplicantForum getApplicantForum(Long forumId);

	FunctionResponse saveApplicantTestDetails(ApplicantTestInfo atest);

	ApplicantTestInfo getApplicantTest(Long testId, Long registerId);

	List<KeyValueDto> getApplicantTestList(Long id);

	ApplicantTestInfo getApplicantTestInfo(Long id);

	FunctionResponse saveApplicantKeys(ApplicantGrade aGrade);

	ApplicantGrade getApplicantGrade(Long id, Long registerId);

	ApplicantGrade getApplicantGradeObj(Long id);

	List<CompanyDto> getJobsList(Long id);

	FunctionResponse updateJobApplied(JobsApplied jobApply);

	List<CompanyDto> getJobsAppliedList(Long id);

	ApplicantDto getSkills(Long id);

	List<KeyValueDto> getCompanyList();

	FunctionResponse updateCompanyRatings(Rating rates);

	List<ApplicantDto> getDoumentsListForPhotos(Long id);

	DocumentsDetails getPhotoDetails(Long id);

}
