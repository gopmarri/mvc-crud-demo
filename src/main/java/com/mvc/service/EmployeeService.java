package com.mvc.service;

import java.util.List;

import com.mvc.dto.Employee;

public interface EmployeeService {

	void addEmployee(Employee e);

	void updateEmployee(Employee e);

	List<Employee> listEmployees();

	Employee getEmployeeById(int id);
}
