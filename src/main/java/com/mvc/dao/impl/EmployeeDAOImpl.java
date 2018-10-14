package com.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mvc.dao.EmployeeDAO;
import com.mvc.dto.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(e);
		LOG.info("Employee saved successfully");
	}

	@Override
	public void updateEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		LOG.info("Employee saved successfully");
	}

	@Override
	public List<Employee> listEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> list = session.createQuery("from employee").list();
		return list;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		LOG.info("Employee loaded successfully, Employee details="+e);
		return e;
	}

}
