package com.chitra.kms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitra.kms.dao.EmployeeDao;
import com.chitra.kms.entity.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
		
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		employeeDao.deleteEmployeeBySsn(ssn);
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		return employeeDao.findEmployeeBySsn(ssn);
	}

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
	@Override
	public void updateEmployee(Employee employee) {
		
		Employee entity = employeeDao.findById(employee.getId());
		if(entity!=null){
			entity.setName(employee.getName());
			entity.setSalary(employee.getSalary());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSsn(employee.getSsn());
		}
		
	}

	@Override
	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = employeeDao.findEmployeeBySsn(ssn);
		return (employee == null || ((id!=null) && (employee.getId() == id)));
	}

}
