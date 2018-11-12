package com.albany.career.service;

import com.albany.career.entity.Registration;
import com.albany.career.entity.Roles;
import com.albany.career.utility.FunctionResponse;

public interface LoginService {

	Roles getRoles(Long id);

	FunctionResponse saveProfileInfo(Registration register);

	FunctionResponse validateUserProfile(String username, String password);

	FunctionResponse updateUserInfo(String email, String password,String confirmpassword);

	FunctionResponse checkUsername(String email);

}
