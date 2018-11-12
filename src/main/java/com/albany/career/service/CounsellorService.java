package com.albany.career.service;

import java.util.List;

import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.ApplicantForum;
import com.albany.career.entity.CounsellorDescription;
import com.albany.career.entity.CounsellorForum;
import com.albany.career.utility.FunctionResponse;

public interface CounsellorService {

	KeyValueDto getCounsellorDetails(Long id, Long roleId);

	ApplicantForum getApplicantForum(Long forumId);

	FunctionResponse saveReplyMessages(CounsellorForum cForum);

	List<CounselorDto> getCounsellorForum(Long forumId, Long registerId);

	List<CounselorDto> getCounsellorForum(Long forumId);

	CounselorDto getCounselorDescription(Long id);

	CounsellorDescription getCounsellorDescription(Long id);

	FunctionResponse updateCounsellorDescription(CounsellorDescription data);

}
