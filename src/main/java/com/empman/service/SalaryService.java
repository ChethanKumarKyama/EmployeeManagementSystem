package com.empman.service;

import com.empman.entity.Salary;

public interface SalaryService {
	void createSalary(Salary salary);
	void deleteSalary(Salary salary);
	void updateSalary(Salary salary);
	void getSalary(int id);
	Salary getSalaryD(int id);
	void getSalaries();
}
