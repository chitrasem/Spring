package com.chitra.kms.service.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.chitra.kms.domain.test.User;

@Service("userServiceTest")
@Transactional
public class UserServiceImplTest implements UserServiceTest{
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static{
		users = populateDummyUsers();
	}

	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}

	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
		
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
		
	}

	public void deleteUserById(long id) {
		for(Iterator<User> iterator = users.iterator(); iterator.hasNext(); ){
			User user = iterator.next();
			if (user.getId() == id){
				iterator.remove();
			}
			
		}
		
	}

	public List<User> findAllUsers() {
		return users;
	}

	public void deleteAllUsers() {
		users.clear();
	}

	public boolean isUserExist(User user) {
		
		return findByName(user.getName())!=null;
	}


	private static List<User> populateDummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "Chitra", 30, 90000));
		users.add(new User(counter.incrementAndGet(), "Borith", 30, 70000));
		users.add(new User(counter.incrementAndGet(), "Tola", 30, 70000));
		users.add(new User(counter.incrementAndGet(), "Sunleng", 30, 70000));
		users.add(new User(counter.incrementAndGet(), "Penchet", 30, 70000));
		users.add(new User(counter.incrementAndGet(), "Cowboy", 30, 70000));
		return users;
	}

}
