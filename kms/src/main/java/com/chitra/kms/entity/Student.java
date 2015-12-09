package com.chitra.kms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="APP_STUDENT")
public class Student {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
	private int id;
    
    @Column(name = "first_name", nullable=false)
	private String firstName;
    
    @Column(name = "last_name", nullable=false)
	private String lastName;
    
    @Column(nullable=false)
	private String gender;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "APP_STUDENT_SUBJECT",
    		joinColumns = { @JoinColumn(name = "STUDENT_ID")},
    		inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID")}
    		)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Subject> subjects = new ArrayList<Subject>();
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
