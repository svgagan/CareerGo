package com.albany.career.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;

import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.ApplicantGrade;
import com.albany.career.entity.Rating;
import com.albany.career.entity.Registration;
import com.albany.career.entity.TestInfo;
import com.albany.career.service.AdminService;
import com.albany.career.service.ApplicantService;
import com.albany.career.service.CompanyService;
import com.albany.career.service.CounsellorService;
import com.albany.career.service.LoginService;
import com.albany.career.utility.FunctionResponse;

@Controller
public class AdminController {

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
	
	@RequestMapping(value="/adminProfile", method = RequestMethod.GET)
	public String adminProfile(ModelMap model,Long id, Long roleId){
		KeyValueDto register = adminService.getAdminDetails(id,roleId);
		model.addAttribute("register", register);
		return "adminProfile";
	}
	
	@RequestMapping(value="/adminTest", method = RequestMethod.GET)
	public String adminTest(@ModelAttribute KeyValueDto keyvalueDto,ModelMap model,Long id, Long roleId){
		KeyValueDto register = adminService.getAdminDetails(id,roleId);
		model.addAttribute("register", register);
		List<KeyValueDto> testList = adminService.getTestList();
		model.addAttribute("testList",testList);
		model.addAttribute("testInfo",keyvalueDto);
		return "adminTest";
	}
	
	@RequestMapping(value="/adminApplicant", method = RequestMethod.GET)
	public String adminApplicant(ModelMap model,Long id, Long roleId){
		KeyValueDto register = adminService.getAdminDetails(id,roleId);
		model.addAttribute("register", register);
		List<ApplicantDto> applicantList = adminService.getApplicantList();
		model.addAttribute("applicantList",applicantList);
		return "adminApplicant";
	}
	
	@RequestMapping(value="/adminCompany", method = RequestMethod.GET)
	public String adminCompany(ModelMap model,Long id, Long roleId){
		KeyValueDto register = adminService.getAdminDetails(id,roleId);
		model.addAttribute("register", register);
		List<CompanyDto> companyList = adminService.getCompanyList();
		model.addAttribute("companyList",companyList);
		return "adminCompany";
	}
	
	@RequestMapping(value="/adminCounselor", method = RequestMethod.GET)
	public String adminCounselor(ModelMap model,Long id, Long roleId){
		KeyValueDto register = adminService.getAdminDetails(id,roleId);
		model.addAttribute("register", register);
		List<CounselorDto> counselorList = adminService.getCounselorList();
		model.addAttribute("counselorList",counselorList);
		return "adminCounselor";
	}
	
	@RequestMapping(value="/saveTestFile", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveTestFile(@ModelAttribute KeyValueDto testInfo) throws IOException{
		//,ModelMap model,Long rId, Long roleId,String testName,MultipartFile testFile
		Long id = testInfo.getRegisterId();
		Long roleId = testInfo.getRoleId();
		TestInfo test = new TestInfo();
		test.setTestFile(Hibernate.createBlob(testInfo.getTestFile().getInputStream()));
		test.setTestName(testInfo.getTestname());
		test.setTestType(testInfo.getTestFile().getContentType());
		test.setRegister(adminService.getRegistratioDetails(testInfo.getRegisterId()));
		test.setDate(new Date());
		test.setStatus(true);
		Boolean status = adminService.saveTestDetails(test);
		return "redirect:adminTest?id="+id+"&roleId="+roleId;
	}
	
	@RequestMapping(value="/viewTestFile",method=RequestMethod.GET)
    public String viewTestFile(HttpServletResponse response,Long testId) {
        TestInfo test = adminService.getTestInfo(testId);
        if(test!=null)
        {
        try {
        	 response.setHeader("Content-Disposition", "inline;filename=\"" +test.getTestName()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(test.getTestType());
            Blob testfile = test.getTestFile();
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
	
	@RequestMapping(value="/deleteFile", method = {RequestMethod.POST })
	@ResponseBody
	public Boolean deleteFile(Long testId){
		TestInfo test = adminService.getTestInfo(testId);
		test.setStatus(false);
		Boolean status = adminService.saveTestDetails(test);
		return status;
	}
	
	@RequestMapping(value="/updateProfile", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateProfile(Long id,String address,String phone,String gender){
		Registration register = adminService.getRegistratioDetails(id);
		register.setLocation(address);
		register.setPhone(phone);
		register.setGender(gender);
		FunctionResponse response = adminService.saveProfile(register);
		return response;
	}
	
	@RequestMapping(value="/updateStatusDetails", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateStatusDetails(Long registerId){
		Registration register = adminService.getRegistratioDetails(registerId);
		register.setVerified(true);
		FunctionResponse response = adminService.saveProfile(register);
		return response;
	}
	
	@RequestMapping(value="/adminTestGrade", method = RequestMethod.GET)
	public String adminTestGrade(ModelMap model,Long id, Long roleId){
		KeyValueDto register = adminService.getAdminDetails(id,roleId);
		model.addAttribute("register", register);
		List<KeyValueDto> testList = adminService.getTestInfoToGrade();
		model.addAttribute("testList",testList);
		return "adminTestGrade";
	}
	
	@RequestMapping(value="/GradeTest", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse GradeTest(Long testId,String marks){
		ApplicantGrade grade = applicantService.getApplicantGradeObj(testId);
		grade.setMarks(marks);
		FunctionResponse response = applicantService.saveApplicantKeys(grade);
		return response;
	}
	
	@RequestMapping(value="/adminReview", method = RequestMethod.GET)
	public String adminReview(ModelMap model,Long id, Long roleId){
		KeyValueDto register = adminService.getAdminDetails(id,roleId);
		model.addAttribute("register", register);
		List<CompanyDto> reviewList = adminService.getAbusiveReviewList();
		model.addAttribute("reviewList", reviewList);
		return "adminReview";
	}
	
	@RequestMapping(value="/deleteAbusiveRating", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse deleteAbusiveRating(Long reviewId){
		Rating rates = companyService.getRatings(reviewId);
		rates.setStatus(false);
		FunctionResponse response = applicantService.updateCompanyRatings(rates);
		return response;
	}
}
