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
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.CompanyDescription;
import com.albany.career.entity.JobPosts;
import com.albany.career.entity.JobType;
import com.albany.career.entity.JobsApplied;
import com.albany.career.entity.Rating;
import com.albany.career.service.CompanyService;
import com.albany.career.utility.FunctionResponse;

@Service
public class CompanyServiceImpl implements CompanyService {
	
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
	public KeyValueDto getCompanyDetails(Long id, Long roleId) {
		KeyValueDto register = adminDao.getRegistrationDetails(id,roleId);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		register.setsDate(df.format(register.getDate()));
		if(register.getfName() == null){
			register.setfName(" ");
		}
		register.setFullname(register.getfName()+" "+register.getlName());
		if(register.getVerified()){
			register.setvStatus("Verified");
		}else{
			register.setvStatus("Not-Verified");
		}
		return register;
	}

	@Transactional
	public CompanyDto getCompanyDescription(Long id) {
		// TODO Auto-generated method stub
		return companyDao.getCompanyDescription(id);
	}

	@Transactional
	public CompanyDescription getComDescription(Long id) {
		// TODO Auto-generated method stub
		return companyDao.getComDescription(id);
	}

	@Transactional
	public FunctionResponse updateCompanyDescription(CompanyDescription oldData) {
		// TODO Auto-generated method stub
		return companyDao.updateCompanyDescription(oldData);
	}

	@Transactional
	public List<JobType> getJobTypes() {
		// TODO Auto-generated method stub
		return companyDao.getJobTypes();
	}

	@Transactional
	public List<CompanyDto> getJobsList(Long id) {
		List<CompanyDto> jobs = companyDao.getJobsList(id);
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
	public JobType getJobTypes(Long jobTypeId) {
		// TODO Auto-generated method stub
		return companyDao.getJobTypes(jobTypeId);
	}

	@Transactional
	public FunctionResponse updateJobDetails(JobPosts jobs) {
		// TODO Auto-generated method stub
		return companyDao.updateJobDetails(jobs);
	}

	@Transactional
	public JobPosts getJob(Long jobId) {
		// TODO Auto-generated method stub
		return companyDao.getJobs(jobId);
	}

	@Transactional
	public List<CompanyDto> getJobsApplicationReceivedList(Long companyId) {
		List<CompanyDto> jobs = companyDao.getJobsApplicationReceivedList(companyId);
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
	public JobsApplied getJobApplied(Long jobId) {
		// TODO Auto-generated method stub
		return companyDao.getJobApplied(jobId);
	}

	@Transactional
	public List<CompanyDto> getReviewList(Long companyId) {
		// TODO Auto-generated method stub
		List<CompanyDto> review = companyDao.getReviewList(companyId);
		int overallRate = 0;
		if(review.size() > 0){
			int count = review.size();
			int totalRate = 0;
			for (CompanyDto companyDto : review) {
				totalRate = totalRate + companyDto.getStars();
			}
			overallRate = totalRate/count;
		}else{
			overallRate = 0;
		}
		for (CompanyDto companyDto : review) {
			companyDto.setTotalStar(overallRate);
			companyDto.setTitle(companyDto.getName()+" "+companyDto.getCompanyname());
		}
		if(review.size() > 0){
			Collections.reverse(review);
		}
		return review;
	}

	@Transactional
	public Rating getRatings(Long reviewId) {
		// TODO Auto-generated method stub
		return companyDao.getRatings(reviewId);
	}

}
