package com.chitra.kms.dao;

import java.util.List;

import com.chitra.kms.entity.Student;

public interface StudentDao {
	
	List<Student> findAll();
	void save(Student student);
	Student findById(int id);
	Student findBy(String firstName);

}
