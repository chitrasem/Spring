package com.chitra.kms.service.test;



import java.util.List;

import com.chitra.kms.domain.test.User;

public interface UserServiceTest {
	User findById(long id);
	User findByName(String name);
	void saveUser(User user);
	void updateUser(User user);
	void deleteUserById(long id);
	
	List<User> findAllUsers();
	void deleteAllUsers();
	public boolean isUserExist(User user);

}
