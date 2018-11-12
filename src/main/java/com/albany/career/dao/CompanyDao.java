package com.albany.career.dao;

import java.util.List;

import com.albany.career.dto.CompanyDto;
import com.albany.career.entity.CompanyDescription;
import com.albany.career.entity.JobPosts;
import com.albany.career.entity.JobType;
import com.albany.career.entity.JobsApplied;
import com.albany.career.entity.Rating;
import com.albany.career.utility.FunctionResponse;

public interface CompanyDao {

	CompanyDto getCompanyDescription(Long id);

	CompanyDescription getComDescription(Long id);

	FunctionResponse updateCompanyDescription(CompanyDescription oldData);

	List<JobType> getJobTypes();

	List<CompanyDto> getJobsList(Long id);

	JobType getJobTypes(Long jobTypeId);

	FunctionResponse updateJobDetails(JobPosts jobs);

	JobPosts getJobs(Long jobId);

	List<CompanyDto> getJobsList();

	List<CompanyDto> getJobsApplicationReceivedList(Long companyId);

	JobsApplied getJobApplied(Long jobId);

	List<CompanyDto> getReviewList(Long id);

	Rating getRatings(Long reviewId);

}
