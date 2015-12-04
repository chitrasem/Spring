package com.chitra.kms.dao;

import java.util.List;

import com.chitra.kms.entity.UserProfile;

public interface UserProfileDao {
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
	

}
