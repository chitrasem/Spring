package com.chitra.kms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.chitra.kms.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao{

	@Override
	public Employee findById(int id) {
		return getByKey(id);
	}

	@Override 
	public void saveEmployee(Employee employee) {
		
		persist(employee);
		
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createQuery(
				"delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		
		Criteria crit = createEntityCriteria();
		return (List<Employee>) crit.list();
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssn", ssn));
		
		return (Employee) crit.uniqueResult();
	}

}
