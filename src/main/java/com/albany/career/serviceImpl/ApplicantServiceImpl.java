package com.albany.career.serviceImpl;

import java.text.SimpleDateFormat;
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
import com.albany.career.service.ApplicantService;
import com.albany.career.utility.FunctionResponse;

@Service
public class ApplicantServiceImpl implements ApplicantService {

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
	public KeyValueDto getApplicantDetails(Long id, Long roleId) {
		KeyValueDto register = adminDao.getRegistrationDetails(id,roleId);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		register.setsDate(df.format(register.getDate()));
		register.setFullname(register.getfName()+" "+register.getlName());
		if(register.getVerified()){
			register.setvStatus("Verified");
		}else{
			register.setvStatus("Not-Verified");
		}
		return register;
	}

	@Transactional
	public Registration getRegistratioDetails(Long id) {
		// TODO Auto-generated method stub
		return loginDao.getProfile(id);
	}

	@Transactional
	public List<ApplicantDto> getEducationList(Long id) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<ApplicantDto> education = applicantDao.getEducationList(id);
		for (ApplicantDto applicantDto : education) {
			applicantDto.setStartdate(df.format(applicantDto.getStartDate()));
			applicantDto.setEnddate(df.format(applicantDto.getEndDate()));
		}
		return education;
	}

	@Transactional
	public List<Major> getMajorList() {
		// TODO Auto-generated method stub
		return applicantDao.getMajorList();
	}

	@Transactional
	public List<Degree> getDegreeList() {
		// TODO Auto-generated method stub
		return applicantDao.getDegreeList();
	}

	@Transactional
	public FunctionResponse updateEducation(EducationDetails education) {
		// TODO Auto-generated method stub
		return applicantDao.updateEducation(education);
	}

	@Transactional
	public Degree getDegree(Long degreeId) {
		// TODO Auto-generated method stub
		return applicantDao.getDegree(degreeId);
	}

	@Transactional
	public Major getMajor(Long majorId) {
		// TODO Auto-generated method stub
		return applicantDao.getMajor(majorId);
	}

	@Transactional
	public EducationDetails getEducationDetails(Long eId) {
		// TODO Auto-generated method stub
		return applicantDao.getEducationDetails(eId);
	}

	@Transactional
	public ApplicantDto getSkills(Long id) {
		// TODO Auto-generated method stub
		return applicantDao.getSkills(id);
	}

	@Transactional
	public SkillsDetails getSkillsDetails(Long sID) {
		// TODO Auto-generated method stub
		return applicantDao.getSkillsDetails(sID);
	}

	@Transactional
	public FunctionResponse updateSkills(SkillsDetails skill) {
		// TODO Auto-generated method stub
		return applicantDao.updateSkills(skill);
	}

	@Transactional
	public List<ApplicantDto> getCertificateList(Long id) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<ApplicantDto> certificate = applicantDao.getCertificateList(id);
		for (ApplicantDto applicantDto : certificate) {
			applicantDto.setStartdate(df.format(applicantDto.getStartDate()));
			applicantDto.setEnddate(df.format(applicantDto.getEndDate()));
		}
		return certificate;
	}

	@Transactional
	public FunctionResponse updateCertificate(CertificationDetails certificates) {
		// TODO Auto-generated method stub
		return applicantDao.updateCertificate(certificates);
	}

	@Transactional
	public CertificationDetails getCertifcate(Long cId) {
		// TODO Auto-generated method stub
		return applicantDao.getCertificate(cId);
	}

	@Transactional
	public List<ApplicantDto> getProjectsList(Long id) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<ApplicantDto> projects = applicantDao.getProjectsList(id);
		for (ApplicantDto applicantDto : projects) {
			applicantDto.setStartdate(df.format(applicantDto.getStartDate()));
			applicantDto.setEnddate(df.format(applicantDto.getEndDate()));
		}
		return projects;
	}
	
	@Transactional
	public FunctionResponse updateProjects(ProjectDetails project) {
		// TODO Auto-generated method stub
		return applicantDao.updateProjects(project);
	}

	@Transactional
	public ProjectDetails getProject(Long pId) {
		// TODO Auto-generated method stub
		return applicantDao.getProject(pId);
	}

	@Transactional
	public FunctionResponse updateProject(ProjectDetails project) {
		// TODO Auto-generated method stub
		return applicantDao.updateProjects(project);
	}

	@Transactional
	public List<ApplicantDto> getWorkList(Long id) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<ApplicantDto> work = applicantDao.getWorkList(id);
		for (ApplicantDto applicantDto : work) {
			applicantDto.setStartdate(df.format(applicantDto.getStartDate()));
			applicantDto.setEnddate(df.format(applicantDto.getEndDate()));
		}
		return work;
	}

	@Transactional
	public FunctionResponse updateWork(WorkDetails working) {
		// TODO Auto-generated method stub
		return applicantDao.updateWork(working);
	}

	@Transactional
	public WorkDetails getWork(Long wId) {
		// TODO Auto-generated method stub
		return applicantDao.getWork(wId);
	}

	@Transactional
	public List<DocumentType> getDocumentTypes() {
		// TODO Auto-generated method stub
		return applicantDao.getDocumentTypes();
	}

	@Transactional
	public DocumentType getDocumentType(Long docTypeId) {
		// TODO Auto-generated method stub
		return applicantDao.getDocumentType(docTypeId);
	}

	@Transactional
	public FunctionResponse saveDocumentDetails(DocumentsDetails documentsDetails) {
		// TODO Auto-generated method stub
		return applicantDao.saveDocumentDetails(documentsDetails);
	}

	@Transactional
	public List<ApplicantDto> getDoumentsList(Long id) {
		List<ApplicantDto> docs = applicantDao.getDoumentsList(id);
		if(docs.size() > 0){
			Collections.reverse(docs);
		}
		return docs;
	}

	@Transactional
	public DocumentsDetails getDocumentDetails(Long docId) {
		// TODO Auto-generated method stub
		return applicantDao.getDocumentDetails(docId);
	}

	@Transactional
	public List<ApplicantDto> getMessagesList(Long id) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<ApplicantDto> messages = applicantDao.getMessagesList(id);
		for (ApplicantDto applicantDto : messages) {
			applicantDto.setsDate(df.format(applicantDto.getdDate()));
			if(applicantDto.getResponseStatus()){
				applicantDto.setvStatus("Replied");
			}else{
				applicantDto.setvStatus("Not-Replied");
			}
		}
		if(messages.size() > 0){
			Collections.reverse(messages);
		}
		return messages;
	}

	@Transactional
	public FunctionResponse saveMessages(ApplicantForum aForum) {
		// TODO Auto-generated method stub
		return applicantDao.saveMessages(aForum);
	}

	@Transactional
	public List<ApplicantDto> getMessagesList() {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<ApplicantDto> messages = applicantDao.getMessagesList();
		for (ApplicantDto applicantDto : messages) {
			applicantDto.setsDate(df.format(applicantDto.getdDate()));
			Registration registerobj = loginDao.getProfile(applicantDto.getRegisterId());
			applicantDto.setName(registerobj.getFirstname()+" "+registerobj.getLastname());
			if(applicantDto.getResponseStatus()){
				applicantDto.setvStatus("Replied");
			}else{
				applicantDto.setvStatus("Not-Replied");
			}
		}
		if(messages.size() > 0){
			Collections.reverse(messages);
		}
		return messages;
	}

	@Transactional
	public ApplicantForum getApplicantForum(Long forumId) {
		// TODO Auto-generated method stub
		return applicantDao.getApplicantForum(forumId);
	}

	@Transactional
	public FunctionResponse saveApplicantTestDetails(ApplicantTestInfo atest) {
		// TODO Auto-generated method stub
		return applicantDao.saveApplicantTestDetails(atest);
	}

	@Transactional
	public ApplicantTestInfo getApplicantTest(Long testId, Long registerId) {
		// TODO Auto-generated method stub
		return applicantDao.getApplicantTest(testId, registerId);
	}
	
	@Transactional
	public List<KeyValueDto> getApplicantTestList(Long id){
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<KeyValueDto> testList = applicantDao.getApplicantTestList(id);
		for (KeyValueDto keyValueDto : testList) {
			keyValueDto.setsDate(df.format(keyValueDto.getDate()));
			ApplicantGrade aGrade = applicantDao.getApplicantGrade(keyValueDto.getId(), keyValueDto.getRegisterId());
			if(aGrade == null || aGrade.equals(null)){
				keyValueDto.setMarks("NA");
				keyValueDto.setVerified(false);
			}else{
				keyValueDto.setMarks(aGrade.getMarks());
				keyValueDto.setVerified(true);
			}
		}
		if(testList.size() > 0){
			Collections.reverse(testList);
		}
		return testList;
	}

	@Transactional
	public ApplicantTestInfo getApplicantTestInfo(Long id) {
		// TODO Auto-generated method stub
		return applicantDao.getApplicantTest(id);
	}

	@Transactional
	public FunctionResponse saveApplicantKeys(ApplicantGrade aGrade) {
		// TODO Auto-generated method stub
		return applicantDao.saveApplicantKeys(aGrade);
	}

	@Transactional
	public ApplicantGrade getApplicantGrade(Long id, Long registerId) {
		// TODO Auto-generated method stub
		return applicantDao.getApplicantGrade(id,registerId);
	}

	@Transactional
	public ApplicantGrade getApplicantGradeObj(Long id) {
		// TODO Auto-generated method stub
		return applicantDao.getApplicantGradeObj(id);
	}

	@Transactional
	public List<CompanyDto> getJobsList(Long registerId) {
		List<CompanyDto> jobs = companyDao.getJobsList();
		List<ApplicantDto> jobApplied = applicantDao.getJobsApplied(registerId);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		if(jobApplied.size() > 0){
			for (CompanyDto companyDto : jobs) {
				for (ApplicantDto applicantDto : jobApplied) {
					if(companyDto.getJobId().equals(applicantDto.getJobPostId())){
						companyDto.setbStatus(true);break;
					}else{
						companyDto.setbStatus(false);
					}
				}
				companyDto.setsDate(df.format(companyDto.getCreatedDate()));
			}
		}else{
			for (CompanyDto companyDto : jobs) {
				companyDto.setsDate(df.format(companyDto.getCreatedDate()));
				companyDto.setbStatus(false);
			}
		}
		if(jobs.size() > 0){
			Collections.reverse(jobs);
		}
		return jobs;
	}

	@Transactional
	public FunctionResponse updateJobApplied(JobsApplied jobApply) {
		// TODO Auto-generated method stub
		return applicantDao.updateJobApplied(jobApply);
	}

	@Transactional
	public List<CompanyDto> getJobsAppliedList(Long id) {
		List<CompanyDto> jobs = applicantDao.getJobsAppliedList(id);
		for (CompanyDto companyDto : jobs) {
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			companyDto.setsDate(df.format(companyDto.getCreatedDate()));
		}
		if(jobs.size() > 0){
			Collections.reverse(jobs);
		}
		return jobs;
	}

	@Transactional
	public List<KeyValueDto> getCompanyList() {
		List<KeyValueDto> company = applicantDao.getCompanyList();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		for (KeyValueDto keyValueDto : company) {
			keyValueDto.setsDate(df.format(keyValueDto.getDate()));
			List<CompanyDto> rating = applicantDao.getCompanyRates(keyValueDto.getId());
			int overallRate = 0;
			if(rating.size() > 0){
				int count = rating.size();
				int totalRate = 0;
				for (CompanyDto companyDto : rating) {
					totalRate = totalRate + companyDto.getStars();
				}
				overallRate = totalRate/count;
			}else{
				overallRate = 0;
			}
			keyValueDto.setStars(overallRate);
		}
		if(company.size() > 0){
			Collections.reverse(company);
		}
		return company;
	}

	@Transactional
	public FunctionResponse updateCompanyRatings(Rating rates) {
		// TODO Auto-generated method stub
		return applicantDao.updateCompanyRatings(rates);
	}

	@Transactional
	public List<ApplicantDto> getDoumentsListForPhotos(Long id) {
		// TODO Auto-generated method stub
		return applicantDao.getDoumentsListForPhotos(id);
	}

	@Transactional
	public DocumentsDetails getPhotoDetails(Long id) {
		List<ApplicantDto> doc = applicantDao.getDoumentsListForPhotos(id);
		DocumentsDetails docs = null;
		if(doc.size() > 0){
			Collections.reverse(doc);
			docs = applicantDao.getDocumentDetails(doc.get(0).getDocId());//Recent Profile Photo
		}else{
			docs = null;
		}
		return docs;
	}

}
