package com.chitra.kms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.kms.dao.StudentDao;
import com.chitra.kms.entity.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public void save(Student student) {
		studentDao.save(student);
		
	}

	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	public Student findBy(String firstName) {
		return studentDao.findBy(firstName);
	}

}
