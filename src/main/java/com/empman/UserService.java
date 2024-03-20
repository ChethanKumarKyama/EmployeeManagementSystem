package com.empman;

import java.util.Scanner;

import com.empman.service.DomainService;
import com.empman.service.EmployeeService;
import com.empman.service.ProjectService;
import com.empman.service.SalaryService;
import com.empman.serviceImpl.DomainServiceImpl;
import com.empman.serviceImpl.EmployeeServiceImpl;
import com.empman.serviceImpl.ProjectServiceImpl;
import com.empman.serviceImpl.SalaryServiceImpl;

public class UserService {
	Scanner sc = new Scanner(System.in);
	void user(int detail){
		EmployeeService empService= new EmployeeServiceImpl();
		DomainService domService = new DomainServiceImpl();
		ProjectService proService = new ProjectServiceImpl();
		SalaryService salService = new SalaryServiceImpl();
		System.out.println("\n\n0.exit from the user");
		System.out.println("1.get single Employee details");
		System.out.println("2.get single domain details");
		System.out.println("3.get single project details");
		System.out.println("4.get single salary details");
		System.out.println("5.get all Employee details");
		System.out.println("6.get all Domain details");
		System.out.println("7.get all Project details");
		System.out.println("8.get all Project managers");
		System.out.println("9.get all Salary details\n\n");
		int details = sc.nextInt();
		int id;
		switch(details) {
			case 0:
				detail = 0;
				break;
			case 1:
				System.out.println("Enter employee id");
				id = sc.nextInt();
				empService.getEmployee(id);
				break;
			case 2:
				System.out.println("Enter domain id");
				id = sc.nextInt();
				domService.getDomain(id);
				break;
			case 3:
				System.out.println("Enter project id");
				id = sc.nextInt();
				proService.getProject(id);
				break;
			case 4:
				System.out.println("Enter salary id");
				id = sc.nextInt();
				salService.getSalary(id);
				break;
			case 5:
				empService.getEmployees();
				break;
			case 6:
				domService.getDomains();
				break;
			case 7:
				proService.getProjects();
				break;
			case 8:
				proService.getprojectMembers();
				break;
			case 9:
				salService.getSalaries();
				break;
			default:
				System.out.println("Enter valid Input");
				break;
		}
	}
}
