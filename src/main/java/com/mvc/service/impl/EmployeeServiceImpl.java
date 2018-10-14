package com.mvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.EmployeeDAO;
import com.mvc.dto.Employee;
import com.mvc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	@Transactional
	public void addEmployee(Employee e) {
		employeeDAO.addEmployee(e);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		employeeDAO.updateEmployee(e);
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return employeeDAO.listEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}

}
