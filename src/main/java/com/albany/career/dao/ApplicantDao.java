package com.albany.career.dao;

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
import com.albany.career.entity.SkillsDetails;
import com.albany.career.entity.WorkDetails;
import com.albany.career.utility.FunctionResponse;

public interface ApplicantDao {

	List<ApplicantDto> getEducationList(Long id);

	List<Major> getMajorList();

	List<Degree> getDegreeList();

	FunctionResponse updateEducation(EducationDetails education);

	Degree getDegree(Long degreeId);

	Major getMajor(Long majorId);

	EducationDetails getEducationDetails(Long eId);

	ApplicantDto getSkills(Long id);

	SkillsDetails getSkillsDetails(Long sID);

	FunctionResponse updateSkills(SkillsDetails skill);

	List<ApplicantDto> getCertificateList(Long id);

	FunctionResponse updateCertificate(CertificationDetails certificates);

	CertificationDetails getCertificate(Long cId);

	List<ApplicantDto> getProjectsList(Long id);

	FunctionResponse updateProjects(ProjectDetails project);

	ProjectDetails getProject(Long pId);

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

	ApplicantTestInfo getApplicantTest(Long id);

	FunctionResponse saveApplicantKeys(ApplicantGrade aGrade);

	ApplicantGrade getApplicantGrade(Long id, Long registerId);

	ApplicantGrade getApplicantGradeObj(Long id);

	List<ApplicantDto> getJobsApplied(Long registerId);

	FunctionResponse updateJobApplied(JobsApplied jobApply);

	List<CompanyDto> getJobsAppliedList(Long id);

	List<KeyValueDto> getCompanyList();

	List<CompanyDto> getCompanyRates(Long id);

	FunctionResponse updateCompanyRatings(Rating rates);

	List<ApplicantDto> getDoumentsListForPhotos(Long id);

}
