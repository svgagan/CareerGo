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
import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.ApplicantForum;
import com.albany.career.entity.CounsellorDescription;
import com.albany.career.entity.CounsellorForum;
import com.albany.career.entity.DocumentsDetails;
import com.albany.career.entity.Registration;
import com.albany.career.service.AdminService;
import com.albany.career.service.ApplicantService;
import com.albany.career.service.CompanyService;
import com.albany.career.service.CounsellorService;
import com.albany.career.service.LoginService;
import com.albany.career.utility.FunctionResponse;

@Controller
public class CounsellorController {
	
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
	
	@RequestMapping(value="/counselorBasic", method = RequestMethod.GET)
	public String counselorBasicProfile(ModelMap model,Long id, Long roleId){
		KeyValueDto register = counsellorService.getCounsellorDetails(id,roleId);
		model.addAttribute("register", register);
		CounselorDto counsellor = counsellorService.getCounselorDescription(id);
		model.addAttribute("counsellor", counsellor);//Profile Photo
		return "counselorPersonal";
	}
	
	@RequestMapping(value="/updateCounselorProfile", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse updateCounselorProfile(Long id,String address,String phone,String gender){
		Registration register = applicantService.getRegistratioDetails(id);
		register.setLocation(address);
		register.setPhone(phone);
		register.setGender(gender);
		FunctionResponse response = adminService.saveProfile(register);
		return response;
	}
	
	@RequestMapping(value="/counselorForum", method = RequestMethod.GET)
	public String counselorForum(ModelMap model,Long id, Long roleId,ApplicantDto replyForum){
		List<ApplicantDto> messageList = applicantService.getMessagesList();
		model.addAttribute("messageList", messageList);
		KeyValueDto register = counsellorService.getCounsellorDetails(id,roleId);
		model.addAttribute("register", register);
		model.addAttribute("replyForum", replyForum);
		CounselorDto counsellor = counsellorService.getCounselorDescription(id);
		model.addAttribute("counsellor", counsellor);//Profile Photo
		return "counselorForum";
	}
	
	@RequestMapping(value="/saveReply", method = {RequestMethod.POST })
	@ResponseBody
	public FunctionResponse saveReply(@ModelAttribute ApplicantDto replyForum) throws IOException{
		//return "redirect:applicantForum?id="+id+"&roleId="+roleId;
		Long id = replyForum.getRegisterId();
		Long roleId = replyForum.getRoleId();
		ApplicantForum aforum = counsellorService.getApplicantForum(replyForum.getForumId());
		aforum.setResponse(true);
		FunctionResponse status = applicantService.saveMessages(aforum);
		
		CounsellorForum cForum = new CounsellorForum();
		cForum.setStatus(true);
		cForum.setDate(new Date());
		cForum.setCounsellorMessage(replyForum.getMessage());
		cForum.setRegister(adminService.getRegistratioDetails(replyForum.getRegisterId()));
		cForum.setForum(counsellorService.getApplicantForum(replyForum.getForumId()));
		FunctionResponse rstatus = counsellorService.saveReplyMessages(cForum);
		return rstatus;
		
	}
	
	@RequestMapping(value="/viewResponses", method = {RequestMethod.POST })
	@ResponseBody
	public List<CounselorDto> viewResponses(Long forumId,Long registerId) throws IOException{
		List<CounselorDto> messages = counsellorService.getCounsellorForum(forumId,registerId);
		return messages;
	}
	
	@RequestMapping(value="/counselorProfile", method = RequestMethod.GET)
	public String counselorProfile(ModelMap model,Long id, Long roleId, CounselorDto counsellorDesc){
		KeyValueDto register = counsellorService.getCounsellorDetails(id,roleId);
		model.addAttribute("register", register);
		CounselorDto counsellor = counsellorService.getCounselorDescription(id);
		model.addAttribute("counsellor", counsellor);
		model.addAttribute("counsellorDesc", counsellorDesc);
		return "counselorDescription";
	}
	
	@RequestMapping(value="/saveDescription", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveDocsFile(@ModelAttribute CounselorDto counsellorDesc) throws IOException{
		Long id = counsellorDesc.getRegisterId();
		Long roleId = counsellorDesc.getRoleId();
		FunctionResponse status = new FunctionResponse();
		CounsellorDescription oldData = new CounsellorDescription();
		if(counsellorDesc.getId() == null || counsellorDesc.getId().equals(null)){
			oldData = null;
		}else{
			oldData = counsellorService.getCounsellorDescription(counsellorDesc.getId());
		}
		if(oldData == null || oldData.equals(null)){
			CounsellorDescription data = new CounsellorDescription();
			data.setPhoto((Hibernate.createBlob(counsellorDesc.getPhotoFile().getInputStream())));
			data.setPhotoType((counsellorDesc.getPhotoFile().getContentType()));
			data.setRegister(adminService.getRegistratioDetails(counsellorDesc.getRegisterId()));
			data.setStatus(true);
			data.setDescription(counsellorDesc.getDescription());
			data.setQualification(counsellorDesc.getQualification());
			data.setExperience(counsellorDesc.getExperience());
			status = counsellorService.updateCounsellorDescription(data);
		}else{
			oldData.setPhoto((Hibernate.createBlob(counsellorDesc.getPhotoFile().getInputStream())));
			oldData.setPhotoType((counsellorDesc.getPhotoFile().getContentType()));
			oldData.setRegister(adminService.getRegistratioDetails(counsellorDesc.getRegisterId()));
			oldData.setStatus(true);
			oldData.setDescription(counsellorDesc.getDescription());
			oldData.setQualification(counsellorDesc.getQualification());
			oldData.setExperience(counsellorDesc.getExperience());
			status = counsellorService.updateCounsellorDescription(oldData);
		}
		return "redirect:counselorProfile?id="+id+"&roleId="+roleId;
	}
	
	@RequestMapping(value="/getImage",method=RequestMethod.GET)
    public String viewDocFile(HttpServletResponse response,Long id) {
		CounsellorDescription docs = counsellorService.getCounsellorDescription(id);
        if(docs !=null)
        {
        try {
        	 response.setHeader("Content-Disposition", "inline;filename=\"" +"Image"+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(docs.getPhotoType());
            Blob testfile = docs.getPhoto();
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
