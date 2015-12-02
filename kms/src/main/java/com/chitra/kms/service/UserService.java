package com.chitra.kms.service;

import com.chitra.kms.entity.User;

public interface UserService {
	 
    User findById(int id);
     
    User findBySso(String sso);
     
}
