package com.mvc.dao;

import java.util.List;

import com.mvc.dto.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee p);

	void updateEmployee(Employee p);

	List<Employee> listEmployees();

	Employee getEmployeeById(int id);
}
