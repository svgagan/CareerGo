package com.albany.career.controller;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.ProfileHits;
import com.albany.career.entity.Registration;
import com.albany.career.entity.Roles;
import com.albany.career.service.AdminService;
import com.albany.career.service.ApplicantService;
import com.albany.career.service.CompanyService;
import com.albany.career.service.CounsellorService;
import com.albany.career.service.LoginService;
import com.albany.career.utility.FunctionResponse;

@Controller
public class LoginController {
	
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
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String dashboard(){
		//model.addAttribute("keyValueDto", keyValueDto);
		return "homePage";
	}
	
	@RequestMapping(value="/saveProfile", method = RequestMethod.POST)
	@ResponseBody
	public synchronized FunctionResponse saveProfileDetails(Long roleId,String fName,String lName,String email,String password,String confirmpassword,String phone,String gender,String location){
		FunctionResponse fresponse = new FunctionResponse();
		Pattern pattern = Pattern.compile("\\b[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
		Matcher matcher = pattern.matcher(email);
		/*if(keyValueDto.getRoleId() == 2){
			keyValueDto.setlName(keyValueDto.getCompanyName());
		}*/
		if(lName.isEmpty()){
			fresponse.setFlag(false);
			if(roleId == 2){
				fresponse.setMessage("Invalid Company Name");
			}else{
				fresponse.setMessage("Invalid Lastname");
			}
			return fresponse;
		}else if(email.isEmpty() || !matcher.matches()){
			fresponse.setFlag(false);
			fresponse.setMessage("Invalid Email");
			return fresponse;
		}else if(password.isEmpty() || confirmpassword.isEmpty() || !password.contentEquals(confirmpassword)){
			fresponse.setFlag(false);
			fresponse.setMessage("Invalid Password Details");
			return fresponse;
		}
		else{
			FunctionResponse response = new FunctionResponse();
			response = loginService.checkUsername(email);
			if(response.getFlag()){
				try{
					Roles role = loginService.getRoles(roleId);
					Registration register = new Registration();
					register.setFirstname(fName);
					register.setLastname(lName);	//Acts as Lastname for Applicant & Counsellors roles but act as companyName for company role
					register.setEmail(email);
					register.setGender(gender);
					register.setLocation(location);
					register.setPassword(password);
					register.setPhone(phone);
					register.setStatus(true);
					register.setVerified(false);
					register.setDate(new Date());
					register.setRole(role);
					register.setHits((long)0);
					fresponse = loginService.saveProfileInfo(register);
					/*if(fresponse.getFlag() && roleId == 1){
						ProfileHits profile = new ProfileHits();
						profile.setHits((long)0);
						profile.setStatus(true);
						profile.setRegister(applicantService.getRegistratioDetails(id));
						loginService.saveProfileHits(profile);
					}*/
				}catch(Exception e){
					e.printStackTrace();
				}
				return fresponse;
			}else{
				fresponse.setFlag(false);
				fresponse.setMessage("Email Exists");
				return fresponse;
			}
		}
	}
	
	@RequestMapping(value="/validateUser", method=RequestMethod.POST)
	@ResponseBody
	public synchronized FunctionResponse validateUserProfile(String username,String password){
		FunctionResponse frespResponse = new FunctionResponse();
		if(!username.isEmpty() || !password.isEmpty()){
			frespResponse = loginService.validateUserProfile(username,password);
		}else{
			frespResponse.setMessage("Invalid Login Credentials");
			frespResponse.setFlag(false);
		}
		return frespResponse;
	}
	
	@RequestMapping(value="/forgotPasswordFile", method = RequestMethod.GET)
	public String profile(){
		return "forgotPwd";
	}
	
	@RequestMapping(value="/forgotPassword", method=RequestMethod.POST)
	@ResponseBody
	public synchronized FunctionResponse updateUserInfo(String email,String password,String confirmpassword){
		FunctionResponse freResponse = new FunctionResponse();
		if(!email.isEmpty() && !password.isEmpty() && !confirmpassword.isEmpty() && password.contentEquals(confirmpassword)){
			freResponse = loginService.updateUserInfo(email,password,confirmpassword);
			//return "homepage";
		}else{
			freResponse.setFlag(false);
			freResponse.setMessage("Invalid Details");
			//return "forgotpwd";
		}
		return freResponse;
	}
	
	

}
