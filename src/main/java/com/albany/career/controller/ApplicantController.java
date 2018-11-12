package com.albany.career.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.ApplicantForum;
import com.albany.career.entity.ApplicantGrade;
import com.albany.career.entity.ApplicantTestInfo;
import com.albany.career.entity.CertificationDetails;
import com.albany.career.entity.Degree;
import com.albany.career.entity.DocumentType;
import com.albany.career.entity.DocumentsDetails;
import com.albany.career.entity.EducationDetails;
import com.albany.career.entity.JobPosts;
import com.albany.career.entity.JobsApplied;
import com.albany.career.entity.Major;
import com.albany.career.entity.ProjectDetails;
import com.albany.career.entity.Rating;
import com.albany.career.entity.Registration;
import com.albany.career.entity.SkillsDetails;
import com.albany.career.entity.TestInfo;
import com.albany.career.entity.WorkDetails;
import com.albany.career.service.AdminService;
import com.albany.career.service.ApplicantService;
import com.albany.career.service.CompanyService;
import com.albany.career.service.CounsellorService;
import com.albany.career.service.LoginService;
import com.albany.career.utility.FunctionResponse;

@Controller
public class ApplicantController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	ApplicantService applicantService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CounsellorService counsellorService;
	
	@RequestMapping(value="/applicantProfile", method = RequestMethod.GET)
	public String applicantProfile(ModelMap model,Long id, Long roleId){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantPersonalDetails";
	}
	
	@RequestMapping(value="/applicantEducation", method = RequestMethod.GET)
	public String applicantEducation(ModelMap model,Long id, Long roleId,ApplicantDto eduction){
		List<ApplicantDto> educationList = applicantService.getEducationList(id);
		model.addAttribute("educationList", educationList);
		List<Major> majors = applicantService.getMajorList();
		model.addAttribute("majors", majors);
		List<Degree> degrees = applicantService.getDegreeList();
		model.addAttribute("degrees", degrees);
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		model.addAttribute("eduction", eduction);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantEducationDetails";
	}
	
	@RequestMapping(value="/applicantSkills", method = RequestMethod.GET)
	public String applicantSkills(ModelMap model,Long id, Long roleId){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		ApplicantDto skills = applicantService.getSkills(id);
		model.addAttribute("skills", skills);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantSkills";
	}
	
	@RequestMapping(value="/applicantProjects", method = RequestMethod.GET)
	public String applicantProjects(ModelMap model,Long id, Long roleId,ApplicantDto projects){
		List<ApplicantDto> projectsList = applicantService.getProjectsList(id);
		model.addAttribute("projectsList", projectsList);
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		model.addAttribute("projects", projects);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantProjects";
	}
	
	@RequestMapping(value="/applicantWork", method = RequestMethod.GET)
	public String applicantWork(ModelMap model,Long id, Long roleId,ApplicantDto work){
		List<ApplicantDto> workList = applicantService.getWorkList(id);
		model.addAttribute("workList", workList);
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		model.addAttribute("work", work);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantWorkExperience";
	}
	
	@RequestMapping(value="/applicantCertification", method = RequestMethod.GET)
	public String applicantCertification(ModelMap model,Long id, Long roleId,ApplicantDto certificate){
		List<ApplicantDto> certificateList = applicantService.getCertificateList(id);
		model.addAttribute("certificateList", certificateList);
		model.addAttribute("certificate", certificate);
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantCertifications";
	}
	
	@RequestMapping(value="/applicantDocument", method = RequestMethod.GET)
	public String applicantDocument(ModelMap model,Long id, Long roleId,ApplicantDto documents){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		model.addAttribute("documents", documents);
		List<DocumentType> docsTypes = applicantService.getDocumentTypes();
		model.addAttribute("docsTypes", docsTypes);
		List<ApplicantDto> docsList = applicantService.getDoumentsList(id);
		model.addAttribute("docsList", docsList);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantDocuments";
	}
	
	@RequestMapping(value="/updateApplicantProfile", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateApplicantProfile(Long id,String address,String phone,String gender){
		Registration register = applicantService.getRegistratioDetails(id);
		register.setLocation(address);
		register.setPhone(phone);
		register.setGender(gender);
		FunctionResponse response = adminService.saveProfile(register);
		return response;
	}
	
	@RequestMapping(value="/updateEducationDetails", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateEducationDetails(@ModelAttribute ApplicantDto education){
		EducationDetails educationDetails = new EducationDetails();
		if(education.getEducationId() != (long)0){
			educationDetails.setId(education.getEducationId());
		}
		educationDetails.setDegree(applicantService.getDegree(education.getDegreeId()));
		educationDetails.setMajor(applicantService.getMajor(education.getMajorId()));
		educationDetails.setEndDate(education.getEndDate());
		educationDetails.setStartDate(education.getStartDate());
		educationDetails.setSchool(education.getSchool());
		educationDetails.setStatus(education.getEducationStatus());
		educationDetails.setRegister(applicantService.getRegistratioDetails(education.getRegisterId()));
		FunctionResponse response = applicantService.updateEducation(educationDetails);
		return response;
	}
	
	@RequestMapping(value="/deleteEducationDetail", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse deleteEducationDetail(Long eId){
		EducationDetails education = applicantService.getEducationDetails(eId);
		education.setStatus(false);
		FunctionResponse response = applicantService.updateEducation(education);
		return response;
	}
	
	@RequestMapping(value="/updateSkillsDetails", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateSkillsDetails(Long SID,Long RID,String skills){
		SkillsDetails skill = new SkillsDetails();
		if(SID != (long)0){
			skill = applicantService.getSkillsDetails(SID);
		}else{
			skill.setRegister(applicantService.getRegistratioDetails(RID));
			skill.setStatus(true);
		}
		skill.setSkills(skills);
		FunctionResponse response = applicantService.updateSkills(skill);
		return response;
	}
	
	@RequestMapping(value="/updateCertificateDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateCertificateDetails(@ModelAttribute ApplicantDto certificate){
		CertificationDetails certificates = new CertificationDetails();
		Long id = certificate.getRegisterId();
		Long roleId = certificate.getRoleId();
		if(certificate.getId() != (long)0){
			certificates.setId(certificate.getId());
		}
		certificates.setCertificate(certificate.getCertificate());
		certificates.setAuthority(certificate.getAuthority());
		certificates.setEndDate(certificate.getEndDate());
		certificates.setStartDate(certificate.getStartDate());
		certificates.setStatus(certificate.getStatus());
		certificates.setRegister(applicantService.getRegistratioDetails(certificate.getRegisterId()));
		FunctionResponse response = applicantService.updateCertificate(certificates);
		return "redirect:applicantCertification?id="+id+"&roleId="+roleId;
	}
	
	@RequestMapping(value="/deleteCertificateDetail", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse deleteCertificateDetail(Long cId){
		CertificationDetails certificate = applicantService.getCertifcate(cId);
		certificate.setStatus(false);
		FunctionResponse response = applicantService.updateCertificate(certificate);
		return response;
	}
	
	@RequestMapping(value="/updateProjectDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateProjectDetails(@ModelAttribute ApplicantDto projects){
		ProjectDetails project = new ProjectDetails();
		Long id = projects.getRegisterId();
		Long roleId = projects.getRoleId();
		if(projects.getProjectId() != (long)0){
			project.setId(projects.getProjectId());
		}
		project.setDescription(projects.getDescription());
		project.setTitle(projects.getTitle());
		project.setMembers(projects.getTeams());
		project.setUrl(projects.getUrl());
		project.setEndDate(projects.getEndDate());
		project.setStartDate(projects.getStartDate());
		project.setStatus(projects.getStatus());
		project.setRegister(applicantService.getRegistratioDetails(projects.getRegisterId()));
		FunctionResponse response = applicantService.updateProjects(project);
		return "redirect:applicantProjects?id="+id+"&roleId="+roleId;
	}
	
	@RequestMapping(value="/deleteProjectDetail", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse deleteProjectDetail(Long pId){
		ProjectDetails project = applicantService.getProject(pId);
		project.setStatus(false);
		FunctionResponse response = applicantService.updateProject(project);
		return response;
	}
	
	@RequestMapping(value="/updateWorkDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateWorkDetails(@ModelAttribute ApplicantDto work){
		WorkDetails working = new WorkDetails();
		Long id = work.getRegisterId();
		Long roleId = work.getRoleId();
		if(work.getId() != (long)0){
			working.setId(work.getId());
		}
		working.setDescription(work.getDescription());
		working.setPosition(work.getPosition());
		working.setCompany(work.getCompany());
		working.setLocation(work.getAddress());
		working.setEndDate(work.getEndDate());
		working.setStartDate(work.getStartDate());
		working.setStatus(work.getStatus());
		working.setRegister(applicantService.getRegistratioDetails(work.getRegisterId()));
		FunctionResponse response = applicantService.updateWork(working);
		return "redirect:applicantWork?id="+id+"&roleId="+roleId;
	}
	
	@RequestMapping(value="/deleteWorkDetail", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse deleteWorkDetail(Long wId){
		WorkDetails work = applicantService.getWork(wId);
		work.setStatus(false);
		FunctionResponse response = applicantService.updateWork(work);
		return response;
	}
	
	@RequestMapping(value="/saveDocsFile", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveDocsFile(@ModelAttribute ApplicantDto documents) throws IOException{
		Long id = documents.getRegisterId();
		Long roleId = documents.getRoleId();
		DocumentsDetails documentsDetails = new DocumentsDetails();
		documentsDetails.setDocument(Hibernate.createBlob(documents.getDocFile().getInputStream()));
		documentsDetails.setDocumentName(documents.getDocName());
		documentsDetails.setDocumentType(documents.getDocFile().getContentType());
		documentsDetails.setRegister(adminService.getRegistratioDetails(documents.getRegisterId()));
		documentsDetails.setStatus(true);
		documentsDetails.setDocuments(applicantService.getDocumentType(documents.getDocTypeId()));
		FunctionResponse status = applicantService.saveDocumentDetails(documentsDetails);
		return "redirect:applicantDocument?id="+id+"&roleId="+roleId;
	}
	
	@RequestMapping(value="/viewDocFile",method=RequestMethod.GET)
    public String viewDocFile(HttpServletResponse response,Long docId) {
        DocumentsDetails docs = applicantService.getDocumentDetails(docId);
        if(docs !=null)
        {
        try {
        	 response.setHeader("Content-Disposition", "inline;filename=\"" +docs.getDocumentName()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(docs.getDocumentType());
            Blob testfile = docs.getDocument();
            if(testfile != null){
	            IOUtils.copy(testfile.getBinaryStream(), out);
            }else{
            	out.write(0);
            }
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return null;
    }
	
	@RequestMapping(value="/deleteDocFile", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse deleteDocFile(Long docId){
		DocumentsDetails docs = applicantService.getDocumentDetails(docId);
		docs.setStatus(false);
		FunctionResponse status = applicantService.saveDocumentDetails(docs);
		return status;
	}
	
	@RequestMapping(value="/applicantForum", method = { RequestMethod.GET, RequestMethod.POST })
	public String applicantForum(ModelMap model,Long id, Long roleId,ApplicantDto messagesForum){
		List<ApplicantDto> messageList = applicantService.getMessagesList(id);
		model.addAttribute("messageList", messageList);
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		model.addAttribute("messagesForum", messagesForum);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantForum";
	}
	
	@RequestMapping(value="/saveMessages", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse saveMessages(@ModelAttribute ApplicantDto messagesForum) throws IOException{
		Long id = messagesForum.getRegisterId();
		Long roleId = messagesForum.getRoleId();
		ApplicantForum aForum = new ApplicantForum();
		aForum.setRegister(adminService.getRegistratioDetails(messagesForum.getRegisterId()));
		aForum.setApplicantMessage(messagesForum.getMessage());
		aForum.setDate(new Date());
		aForum.setResponse(false);
		aForum.setStatus(true);
		aForum.setSubject(messagesForum.getSubject());
		//return "redirect:applicantForum?id="+id+"&roleId="+roleId;
		FunctionResponse status = applicantService.saveMessages(aForum);
		return status;
	}
	
	@RequestMapping(value="/viewAllResponses", method = {RequestMethod.POST })
	@ResponseBody
	public List<CounselorDto> viewAllResponses(Long forumId,Long registerId) throws IOException{
		List<CounselorDto> messages = counsellorService.getCounsellorForum(forumId);
		return messages;
	}
	
	@RequestMapping(value="/deleteMessage", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse deleteMessage(Long forumId){
		ApplicantForum aForum = applicantService.getApplicantForum(forumId);
		aForum.setStatus(false);
		FunctionResponse status = applicantService.saveMessages(aForum);
		return status;
	}
	
	@RequestMapping(value="/applicantTest", method = { RequestMethod.GET, RequestMethod.POST })
	public String applicantTest(ModelMap model,Long id, Long roleId){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		List<KeyValueDto> testList = adminService.getTestList();
		model.addAttribute("testList",testList);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantTest";
	}
	
	@RequestMapping(value="/takeTest", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse takeTest(Long testId,Long registerId, Long roleId){
		FunctionResponse resposne = new FunctionResponse();
		ApplicantTestInfo oldTestInfo = applicantService.getApplicantTest(testId,registerId);
		if(oldTestInfo == null || oldTestInfo.equals(null)){
			ApplicantTestInfo atest = new ApplicantTestInfo();
			atest.setStatus(true);
			atest.setDate(new Date());
			atest.setRegister(adminService.getRegistratioDetails(registerId));
			atest.setTest(adminService.getTestInfo(testId));
			resposne = applicantService.saveApplicantTestDetails(atest);
		}else{
			resposne.setFlag(true);
			resposne.setMessage("Updated Successfully");
		}
		return resposne;
	}
	
	@RequestMapping(value="/applicantTestGrade", method = { RequestMethod.GET, RequestMethod.POST })
	public String applicantTestGrade(ModelMap model,Long id, Long roleId, ApplicantDto testData){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		List<KeyValueDto> testList = applicantService.getApplicantTestList(id);
		model.addAttribute("testList",testList);
		model.addAttribute("testData",testData);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantTestGrade";
	}
	
	@RequestMapping(value="/uploadAnswer", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse uploadAnswer(@ModelAttribute ApplicantDto testData){
		FunctionResponse resposne = new FunctionResponse();
		ApplicantGrade old = applicantService.getApplicantGrade(testData.getId(),testData.getRegisterId());
		ApplicantGrade oldGrade = null;
		if(old != null){
			oldGrade = applicantService.getApplicantGradeObj(old.getId());
		}
		if((oldGrade == null || oldGrade.equals(null)) && (old == null || old.equals(null))){
			ApplicantGrade aGrade = new ApplicantGrade();
			aGrade.setDate(new Date());
			aGrade.setStatus(true);
			aGrade.setMarks(testData.getMarks());
			aGrade.setRegister(adminService.getRegistratioDetails(testData.getRegisterId()));
			aGrade.setTestInfo(applicantService.getApplicantTestInfo(testData.getId()));
			aGrade.setUrl(testData.getUrl());
			resposne = applicantService.saveApplicantKeys(aGrade);
		}else{
			oldGrade.setUrl(testData.getUrl());
			oldGrade.setDate(new Date());
			resposne = applicantService.saveApplicantKeys(oldGrade);
		}
		return resposne;
	}
	
	@RequestMapping(value="/applicantJobLists", method = RequestMethod.GET)
	public String applicantJobLists(ModelMap model,Long id, Long roleId){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		List<CompanyDto> jobList = applicantService.getJobsList(id);
		model.addAttribute("jobList", jobList);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantJobLists";
	}
	
	@RequestMapping(value="/applyJobs", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse applyJobs(Long jobId, Long applicantId){
		JobsApplied jobApply = new JobsApplied();
		jobApply.setDate(new Date());
		jobApply.setStatus(true);
		jobApply.setJob(companyService.getJob(jobId));
		jobApply.setCompanyResponse("NA");
		jobApply.setRegister(applicantService.getRegistratioDetails(applicantId));
		FunctionResponse response = applicantService.updateJobApplied(jobApply);
		return response;
	}
	
	@RequestMapping(value="/applicantJobApplied", method = RequestMethod.GET)
	public String applicantJobApplied(ModelMap model,Long id, Long roleId){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		List<CompanyDto> jobList = applicantService.getJobsAppliedList(id);
		model.addAttribute("jobList", jobList);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantJobsApplied";
	}
	
	@RequestMapping(value="/applicantProfileInfo", method = RequestMethod.GET)
	public String applicantProfileInfo(ModelMap model,Long id, Long roleId){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);//,Long id, Long roleId
		model.addAttribute("register", register);
		List<ApplicantDto> educationList = applicantService.getEducationList(id);
		model.addAttribute("educationList", educationList);
		List<ApplicantDto> projectsList = applicantService.getProjectsList(id);
		model.addAttribute("projectsList", projectsList);
		List<ApplicantDto> workList = applicantService.getWorkList(id);
		model.addAttribute("workList", workList);
		List<ApplicantDto> certificateList = applicantService.getCertificateList(id);
		model.addAttribute("certificateList", certificateList);
		List<ApplicantDto> docsList = applicantService.getDoumentsList(id);
		model.addAttribute("docsList", docsList);
		List<KeyValueDto> testList = applicantService.getApplicantTestList(id);
		model.addAttribute("testList",testList);
		ApplicantDto skills = applicantService.getSkills(id);
		model.addAttribute("skills", skills);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantProfileInfo";
	}
	
	@RequestMapping(value="/applicantReview", method = RequestMethod.GET)
	public String applicantReview(ModelMap model,Long id, Long roleId){
		KeyValueDto register = applicantService.getApplicantDetails(id,roleId);
		model.addAttribute("register", register);
		List<KeyValueDto> companyList = applicantService.getCompanyList();
		model.addAttribute("companyList", companyList);
		DocumentsDetails docs = applicantService.getPhotoDetails(id);//Recent Profile Photo based on registerId
		model.addAttribute("docs", docs);
		return "applicantReview";
	}
	
	@RequestMapping(value="/ratings", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse ratings(Long companyId, Long applicantId, Integer rate, String comment){
		Rating rates = new Rating();
		rates.setComments(comment);
		rates.setStars(rate);
		rates.setStatus(true);
		rates.setVerified(true);
		rates.setApplicant(applicantService.getRegistratioDetails(applicantId));
		rates.setCompany(applicantService.getRegistratioDetails(companyId));
		FunctionResponse response = applicantService.updateCompanyRatings(rates);
		return response;
	}
	
	@RequestMapping(value="/getProfilePhoto",method=RequestMethod.GET)
    public String getProfilePhoto(HttpServletResponse response,Long id) {
		List<ApplicantDto> doc = applicantService.getDoumentsListForPhotos(id);
		DocumentsDetails docs = null;
		if(doc.size() > 0){
			Collections.reverse(doc);
			docs = applicantService.getDocumentDetails(doc.get(0).getDocId());//Recent Profile Photo
		}
        if(docs !=null)
        {
        try {
        	 response.setHeader("Content-Disposition", "inline;filename=\"" +docs.getDocumentName()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(docs.getDocumentType());
            Blob testfile = docs.getDocument();
            if(testfile != null){
	            IOUtils.copy(testfile.getBinaryStream(), out);
            }else{
            	out.write(0);
            }
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return null;
    }
}
