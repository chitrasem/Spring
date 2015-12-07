package com.chitra.kms.service;

import java.util.List;

import com.chitra.kms.entity.Student;

public interface StudentService {
	List<Student> findAll();
	void save(Student student);
	Student findById(int id);
	Student findBy(String firstName);

}
