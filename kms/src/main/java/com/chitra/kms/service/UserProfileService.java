package com.chitra.kms.service;

import java.util.List;

import com.chitra.kms.entity.UserProfile;

public interface UserProfileService {
	
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findByid(int id);

}
