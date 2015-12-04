package com.chitra.kms.dao;

import com.chitra.kms.entity.User;

public interface UserDao {
	 
    User findById(int id);
     
    User findBySSO(String sso);
    
    void save(User user);
     
}
