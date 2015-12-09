package com.chitra.kms;

import org.springframework.beans.factory.annotation.Autowired;

import com.chitra.kms.entity.Student;
import com.chitra.kms.entity.Subject;
import com.chitra.kms.service.StudentService;

public class StudentTest {
	
	@Autowired
	StudentService studentDao;
	
	public static void main(String[] args) {
		System.out.println("ldfsajfl");
		StudentTest test = new StudentTest();
		test.createStudent();
		
	}
	public void createStudent(){
		Student s1 = new Student();
		Student s2 = new Student();
		
		Subject sub1 = new Subject();
		Subject sub2 = new Subject();
		Subject sub3 = new Subject();
		Subject sub4 = new Subject();
		
		sub1.setName("English Literature");
		sub2.setName("Khmer Literature");
		sub3.setName("Korean Literature");
		sub4.setName("Japanese Literature");
		
		
		
		s1.setFirstName("Bota");
		s1.setLastName("Ang");
		s1.setGender("Male");
		s1.getSubjects().add(sub1);
		s1.getSubjects().add(sub2);	
		
		s2.setFirstName("Thona");
		s2.setLastName("Leang");
		s2.setGender("Male");
		s2.getSubjects().add(sub4);
		s2.getSubjects().add(sub3);
		
		
		studentDao.save(s1);
		studentDao.save(s2);
	}

}
