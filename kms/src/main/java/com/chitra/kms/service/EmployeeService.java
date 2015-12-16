package com.chitra.kms.service;

import java.util.List;

import com.chitra.kms.entity.Employee;

public interface EmployeeService {
	
Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void deleteEmployeeBySsn(String ssn);
	
	List<Employee> findAllEmployees();
	
	Employee findEmployeeBySsn(String ssn);
	
	void updateEmployee(Employee employee);
	boolean isEmployeeSsnUnique(Integer id, String ssn);
}
