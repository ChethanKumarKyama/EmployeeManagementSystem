package com.empman.service;

import java.util.List;

import com.empman.entity.Employee;

public interface EmployeeService {
	
	void insertEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	void updateEmploye(Employee employee);
	void getEmployee(int id);
	Employee getEmployeeD(int id);
	void getEmployees();
}
