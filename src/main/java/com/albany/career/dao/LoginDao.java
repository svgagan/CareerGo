package com.albany.career.dao;

import java.util.List;

import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.Registration;
import com.albany.career.entity.Roles;
import com.albany.career.utility.FunctionResponse;

public interface LoginDao {

	Roles getRoles(Long id);

	FunctionResponse saveProfileInfo(Registration register);

	List<KeyValueDto> getProfileDetails();

	KeyValueDto getProfileInfo(String email);

	Registration getProfile(Long id);

}
