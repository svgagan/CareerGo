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
import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.ApplicantForum;
import com.albany.career.entity.CounsellorDescription;
import com.albany.career.entity.CounsellorForum;
import com.albany.career.entity.Registration;
import com.albany.career.service.CounsellorService;
import com.albany.career.utility.FunctionResponse;

@Service
public class CounsellorServiceImpl implements CounsellorService{
	
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
	public KeyValueDto getCounsellorDetails(Long id, Long roleId) {
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
	public ApplicantForum getApplicantForum(Long forumId) {
		// TODO Auto-generated method stub
		return counsellorDao.getApplicantForum(forumId);
	}

	@Transactional
	public FunctionResponse saveReplyMessages(CounsellorForum cForum) {
		// TODO Auto-generated method stub
		return counsellorDao.saveReplyMessages(cForum);
	}

	@Transactional
	public List<CounselorDto> getCounsellorForum(Long forumId, Long registerId) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<CounselorDto> messages = counsellorDao.getCounsellorForum(forumId,registerId);
		for (CounselorDto counselorDto : messages) {
			counselorDto.setsDate(df.format(counselorDto.getdDate()));
		}
		if(messages.size() > 0){
			Collections.reverse(messages);
		}
		return messages;
	}

	@Transactional
	public List<CounselorDto> getCounsellorForum(Long forumId) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		List<CounselorDto> messages = counsellorDao.getCounsellorForum(forumId);
		for (CounselorDto counselorDto : messages) {
			counselorDto.setsDate(df.format(counselorDto.getdDate()));
			Registration registerobj = loginDao.getProfile(counselorDto.getRegisterId());
			counselorDto.setFirstname(registerobj.getFirstname()+" "+registerobj.getLastname());
		}
		if(messages.size() > 0){
			Collections.reverse(messages);
		}
		return messages;
	}

	@Transactional
	public CounselorDto getCounselorDescription(Long id) {
		// TODO Auto-generated method stub
		return counsellorDao.getCounselorDescription(id);
	}

	@Transactional
	public CounsellorDescription getCounsellorDescription(Long id) {
		// TODO Auto-generated method stub
		return counsellorDao.getCounsellorDescription(id);
	}

	@Transactional
	public FunctionResponse updateCounsellorDescription(CounsellorDescription data) {
		// TODO Auto-generated method stub
		return counsellorDao.updateCounsellorDescription(data);
	}

}
