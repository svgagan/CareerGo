package com.albany.career.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albany.career.dao.AdminDao;
import com.albany.career.dao.ApplicantDao;
import com.albany.career.dao.CompanyDao;
import com.albany.career.dao.CounsellorDao;
import com.albany.career.dao.LoginDao;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.Registration;
import com.albany.career.entity.Roles;
import com.albany.career.service.LoginService;
import com.albany.career.utility.FunctionResponse;

@Service
public class LoginServiceImpl implements LoginService {
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
	public Roles getRoles(Long id) {
		// TODO Auto-generated method stub
		return loginDao.getRoles(id);
	}
	@Transactional
	public FunctionResponse saveProfileInfo(Registration register) {
		// TODO Auto-generated method stub
		return loginDao.saveProfileInfo(register);
	}
	
	@Transactional
	public FunctionResponse validateUserProfile(String username, String password) {
		// TODO Auto-generated method stub
		List<KeyValueDto> profile = loginDao.getProfileDetails();
		FunctionResponse fresResponse = new FunctionResponse();
		if(profile.size() > 0){
			for (KeyValueDto keyValueDto : profile) {
				if(keyValueDto.getEmail().contentEquals(username) && keyValueDto.getPassword().contentEquals(password)){
					fresResponse.setFlag(true);
					fresResponse.setId(keyValueDto.getId());
					fresResponse.setRoleId(keyValueDto.getRoleId());
					fresResponse.setMessage("LoggedIn Successfully");
					return fresResponse;
				}else{
					fresResponse.setFlag(false);
					fresResponse.setMessage("Invalid Login Credentials");
				}
			}
			return fresResponse;
		}else{
			fresResponse.setFlag(false);
			fresResponse.setMessage("Invalid Login Credentials");
			return fresResponse;
		}
	}
	
	@Transactional
	public FunctionResponse checkUsername(String email) {
		// TODO Auto-generated method stub
		List<KeyValueDto> existingProfile = loginDao.getProfileDetails();
		FunctionResponse fresResponse = new FunctionResponse();
		if(existingProfile.size() > 0){
			for (KeyValueDto keyValueDto : existingProfile) {
				if(keyValueDto.getEmail().contentEquals(email)){
					fresResponse.setFlag(false);
					fresResponse.setMessage("Email Exists");
					return fresResponse;
				}else{
					fresResponse.setFlag(true);
					fresResponse.setMessage("Valid Email");
				}
			}
			return fresResponse;
		}else{
			fresResponse.setFlag(true);
			fresResponse.setMessage("Valid Email");
			return fresResponse;
		}
	}
	
	@Transactional
	public FunctionResponse updateUserInfo(String email, String password,String confirmpassword) {
		// TODO Auto-generated method stub
		KeyValueDto userInfo = loginDao.getProfileInfo(email);
		FunctionResponse freFunctionResponse = new FunctionResponse();
		if(userInfo != null){
			Registration register = loginDao.getProfile(userInfo.getId());
			register.setPassword(password);
			freFunctionResponse = loginDao.saveProfileInfo(register);
			freFunctionResponse.setMessage("Password Updated Successfully");
			return freFunctionResponse;
		}else{
			freFunctionResponse.setFlag(false);
			freFunctionResponse.setMessage("Invalid Profile");
			return freFunctionResponse;
		}
	}
	

}
