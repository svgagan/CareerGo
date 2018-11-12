package com.albany.career.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
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
import com.albany.career.entity.CompanyDescription;
import com.albany.career.entity.CounsellorDescription;
import com.albany.career.entity.EducationDetails;
import com.albany.career.entity.JobPosts;
import com.albany.career.entity.JobType;
import com.albany.career.entity.JobsApplied;
import com.albany.career.entity.Rating;
import com.albany.career.entity.Registration;
import com.albany.career.service.AdminService;
import com.albany.career.service.ApplicantService;
import com.albany.career.service.CompanyService;
import com.albany.career.service.CounsellorService;
import com.albany.career.service.LoginService;
import com.albany.career.utility.FunctionResponse;

@Controller
public class CompanyController {
	
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
	
	@RequestMapping(value="/companyProfile", method = RequestMethod.GET)
	public String companyProfile(ModelMap model,Long id, Long roleId){
		KeyValueDto register = companyService.getCompanyDetails(id,roleId);
		model.addAttribute("register", register);
		CompanyDto company = companyService.getCompanyDescription(id);
		model.addAttribute("company", company);//Company Logo
		return "companyProfile";
	}
	
	@RequestMapping(value="/updateCompanyProfile", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateCompanyProfile(Long id,String address,String phone){
		Registration register = applicantService.getRegistratioDetails(id);
		register.setLocation(address);
		register.setPhone(phone);
		FunctionResponse response = adminService.saveProfile(register);
		return response;
	}
	
	@RequestMapping(value="/companyDetails", method = RequestMethod.GET)
	public String companyDetails(ModelMap model,Long id, Long roleId, CompanyDto companyDetails){
		KeyValueDto register = companyService.getCompanyDetails(id,roleId);
		model.addAttribute("register", register);
		model.addAttribute("companyDetails", companyDetails);
		CompanyDto company = companyService.getCompanyDescription(id);
		model.addAttribute("company", company);
		return "companyDetails";
	}
	
	@RequestMapping(value="/saveCompanyDescription", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveCompanyDescription(@ModelAttribute CompanyDto companyDetails) throws IOException{
		Long id = companyDetails.getRegisterId();
		Long roleId = companyDetails.getRoleId();
		FunctionResponse status = new FunctionResponse();
		CompanyDescription oldData = new CompanyDescription();
		if(companyDetails.getId() == null || companyDetails.getId().equals(null)){
			oldData = null;
		}else{
			oldData = companyService.getComDescription(companyDetails.getId());
		}
		if(oldData == null || oldData.equals(null)){
			CompanyDescription data = new CompanyDescription();
			data.setLogo((Hibernate.createBlob(companyDetails.getLogoFile().getInputStream())));
			data.setLogoType((companyDetails.getLogoFile().getContentType()));
			data.setRegister(adminService.getRegistratioDetails(companyDetails.getRegisterId()));
			data.setStatus(true);
			data.setDescription(companyDetails.getDescription());
			data.setDomain((companyDetails.getDomain()));
			data.setWebsite((companyDetails.getWebsite()));
			status = companyService.updateCompanyDescription(data);
		}else{
			oldData.setLogo((Hibernate.createBlob(companyDetails.getLogoFile().getInputStream())));
			oldData.setLogoType((companyDetails.getLogoFile().getContentType()));
			oldData.setRegister(adminService.getRegistratioDetails(companyDetails.getRegisterId()));
			oldData.setStatus(true);
			oldData.setDescription(companyDetails.getDescription());
			oldData.setDomain((companyDetails.getDomain()));
			oldData.setWebsite((companyDetails.getWebsite()));
			status = companyService.updateCompanyDescription(oldData);
		}
		return "redirect:companyDetails?id="+id+"&roleId="+roleId;
	}
	
	@RequestMapping(value="/getCompanyImage",method=RequestMethod.GET)
    public String viewDocFile(HttpServletResponse response,Long id) {
		CompanyDescription docs = companyService.getComDescription(id);
        if(docs !=null)
        {
        try {
        	 response.setHeader("Content-Disposition", "inline;filename=\"" +"Image"+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(docs.getLogoType());
            Blob testfile = docs.getLogo();
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
	
	@RequestMapping(value="/companyJobs", method = RequestMethod.GET)
	public String companyJobs(ModelMap model,Long id, Long roleId, CompanyDto job){
		KeyValueDto register = companyService.getCompanyDetails(id,roleId);
		model.addAttribute("register", register);
		List<JobType> jobType = companyService.getJobTypes();
		model.addAttribute("jobType", jobType);
		List<CompanyDto> jobsList = companyService.getJobsList(id);
		model.addAttribute("jobsList", jobsList);
		model.addAttribute("job", job);
		CompanyDto company = companyService.getCompanyDescription(id);
		model.addAttribute("company", company);//Company Logo
		return "companyJobs";
	}
	
	@RequestMapping(value="/updateJobPostsDetails", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateJobPostsDetails(@ModelAttribute CompanyDto job){
		JobPosts jobs = new JobPosts();
		if(job.getJobId() != (long)0){
			jobs.setId(job.getJobId());
		}
		jobs.setStatus(true);
		jobs.setDate(new Date());
		jobs.setTitle(job.getTitle());
		jobs.setJobDescription(job.getDescription());
		jobs.setJobLocation(job.getAddress());
		jobs.setSalary(job.getSalary());
		jobs.setPhone(job.getPhone());
		jobs.setEmail(job.getEmail());
		jobs.setJobs(companyService.getJobTypes(job.getJobTypeId()));
		jobs.setRegister(applicantService.getRegistratioDetails(job.getRegisterId()));
		FunctionResponse response = companyService.updateJobDetails(jobs);
		return response;
	}
	
	@RequestMapping(value="/deleteJobPost", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse deleteJobPost(Long jobId){
		JobPosts job = companyService.getJob(jobId);
		job.setStatus(false);
		FunctionResponse response = companyService.updateJobDetails(job);
		return response;
	}
	
	@RequestMapping(value="/companyApplication", method = RequestMethod.GET)
	public String companyApplication(ModelMap model,Long id, Long roleId){
		KeyValueDto register = companyService.getCompanyDetails(id,roleId);
		model.addAttribute("register", register);
		List<CompanyDto> ApplicationList = companyService.getJobsApplicationReceivedList(id);
		model.addAttribute("ApplicationList", ApplicationList);
		CompanyDto company = companyService.getCompanyDescription(id);
		model.addAttribute("company", company);//Company Logo
		return "companyApplication";
	}
	
	@RequestMapping(value="/respondToJobApplication", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse respondToJobApplication(Long jobId, String message){
		JobsApplied jobs = companyService.getJobApplied(jobId);
		jobs.setCompanyResponse(message);
		FunctionResponse response = applicantService.updateJobApplied(jobs);
		return response;
	}
	
	@RequestMapping(value="/updateProfileHits", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateProfileHits(Long applicantId){
		Registration register = applicantService.getRegistratioDetails(applicantId);
		Long hit = register.getHits()+1;
		register.setHits(hit);
		FunctionResponse response = adminService.saveProfile(register);
		return response;
	}
	
	@RequestMapping(value="/companyReview", method = RequestMethod.GET)
	public String companyReview(ModelMap model,Long id, Long roleId){
		KeyValueDto register = companyService.getCompanyDetails(id,roleId);
		model.addAttribute("register", register);
		List<CompanyDto> reviewList = companyService.getReviewList(id);
		model.addAttribute("reviewList", reviewList);
		Integer overallRate = 0;
		if(reviewList.size() > 0){
			overallRate = reviewList.get(0).getTotalStar();
		}else{
			overallRate = 0;
		}
		model.addAttribute("overallRate", overallRate);
		CompanyDto company = companyService.getCompanyDescription(id);
		model.addAttribute("company", company);//Company Logo
		return "companyReview";
	}
	
	@RequestMapping(value="/reportReviews", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse reportReviews(Long reviewId){
		Rating rates = companyService.getRatings(reviewId);
		rates.setVerified(false);
		FunctionResponse response = applicantService.updateCompanyRatings(rates);
		return response;
	}
	
}
