package com.albany.career.service;

import java.util.List;

import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.CompanyDescription;
import com.albany.career.entity.JobPosts;
import com.albany.career.entity.JobType;
import com.albany.career.entity.JobsApplied;
import com.albany.career.entity.Rating;
import com.albany.career.utility.FunctionResponse;

public interface CompanyService {

	KeyValueDto getCompanyDetails(Long id, Long roleId);

	CompanyDto getCompanyDescription(Long id);

	CompanyDescription getComDescription(Long id);

	FunctionResponse updateCompanyDescription(CompanyDescription oldData);

	List<JobType> getJobTypes();

	List<CompanyDto> getJobsList(Long id);

	JobType getJobTypes(Long jobTypeId);

	FunctionResponse updateJobDetails(JobPosts jobs);

	JobPosts getJob(Long jobId);

	List<CompanyDto> getJobsApplicationReceivedList(Long id);

	JobsApplied getJobApplied(Long jobId);

	List<CompanyDto> getReviewList(Long id);

	Rating getRatings(Long reviewId);


}
