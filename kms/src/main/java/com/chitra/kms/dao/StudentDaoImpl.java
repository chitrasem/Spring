package com.chitra.kms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.chitra.kms.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao{

	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("firstName"));
		
		return (List<Student>)crit.list();
	}

	public void save(Student student) {
		persist(student);
		
	}

	public Student findById(int id) {
		return getByKey(id);
	}

	public Student findBy(String firstName) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("firstName", firstName));
        return (Student) crit.uniqueResult();
	}

}
