package com.empman;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.empman.entity.Domain;
import com.empman.entity.Employee;
import com.empman.entity.Project;
import com.empman.entity.Salary;
import com.empman.service.DomainService;
import com.empman.service.EmployeeService;
import com.empman.service.ProjectService;
import com.empman.service.SalaryService;
import com.empman.serviceImpl.DomainServiceImpl;
import com.empman.serviceImpl.EmployeeServiceImpl;
import com.empman.serviceImpl.ProjectServiceImpl;
import com.empman.serviceImpl.SalaryServiceImpl;

public class EmpMangementImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeService empService= new EmployeeServiceImpl();
		DomainService domService = new DomainServiceImpl();
		ProjectService proService = new ProjectServiceImpl();
		SalaryService salService = new SalaryServiceImpl();
		System.out.println("Employee Management System ");
		Scanner sc = new Scanner(System.in);
		System.out.println("You are: \n	1.User\n	2.Admin");
		int user = sc.nextInt();
		int detail = 1;
		while(detail!=0) {
			if(user == 1) {
				
				System.out.println("\n\n0.exit from the user");
				System.out.println("1.get single Employee details");
				System.out.println("2.get single domain details");
				System.out.println("3.get single project details");
				System.out.println("4.get single salary details");
				System.out.println("5.get all Employee details");
				System.out.println("6.get all Domain details");
				System.out.println("7.get all Project details");
				System.out.println("8.get all Project members");
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
			}else if(user == 2) {
				System.out.println("\n\n0.exit from the user");
				System.out.println("1.get single Employee details");
				System.out.println("2.get single domain details");
				System.out.println("3.get single project details");
				System.out.println("4.get single salary details");
				System.out.println("5.get all Employee details");
				System.out.println("6.get all Domain details");
				System.out.println("7.get all Project details");
				System.out.println("8.get all Project members");
				System.out.println("9.get all Salary details\n");
				System.out.println("10.add employee details");
				System.out.println("11.add domain details");
				System.out.println("12.add project details");
				System.out.println("13.add salary details\n");
				System.out.println("add details : ");
				System.out.println("14.add domain, salary, project to employee ");
				System.out.println("15.add employees to domain ");
				System.out.println("16.add employee to project ");
				System.out.println("17.add employee to salary \n");
				System.out.println("delete details : ");
				System.out.println("18.delete employee : ");
				System.out.println("19.delete domain : ");
				System.out.println("20.delete salary : ");
				System.out.println("21.delete project : ");
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
					case 10:
						Employee e1 = new Employee();
						System.out.println("enter employee id ");
						e1.setEmployeeId(sc.nextInt());
						System.out.print("");
						e1.setFirstName(sc.nextLine());
						System.out.println("enter employee firstName ");
						e1.setFirstName(sc.nextLine());
						System.out.println("enter employee lastname ");
						e1.setLastName(sc.nextLine());
						System.out.println("enter employee email id ");
						e1.setEmail(sc.nextLine());
						System.out.println("enter job title "); 
						e1.setJobTitle(sc.nextLine()); 
						System.out.println("enter employee number ");
						e1.setPhoneNo(sc.nextLine());
						System.out.println("enter employee hireDate ");
						try {
							System.out.println("Enter hired year");
							int year = sc.nextInt();
							System.out.println("Enter hired month");
							int month = sc.nextInt();
							System.out.println("Enter hired dayOfTheMonth");
							int day = sc.nextInt();
							e1.setHireDate(LocalDate.of(year, month, day));
						}catch(Exception e) {
							System.out.println("Enter valid input");
							continue;
						}
						empService.insertEmployee(e1);
						break;
						
					case 11:
						Domain d1 = new Domain();
						System.out.println("Enter domain id");
						d1.setDomainId(sc.nextInt());
						System.out.println(" ");
						d1.setDomainName(sc.nextLine());
						System.out.println("Enter domain name");
						d1.setDomainName(sc.nextLine());
						domService.createDomain(d1);
						break;
						
					case 12:
						Project p1 = new Project();
						System.out.println("Enter project id");
						p1.setProjectId(sc.nextInt());
						System.out.print("");
						p1.setProjectName(sc.nextLine());
						System.out.println("Enter project name");
						p1.setProjectName(sc.nextLine());
						System.out.println("Enter start date");
						try {
							System.out.println("Enter start year");
							int year = sc.nextInt();
							System.out.println("Enter start month");
							int month = sc.nextInt();
							System.out.println("Enter start dayOfTheMonth");
							int day = sc.nextInt();
							p1.setStartDate(LocalDate.of(year, month, day));
						}catch(Exception e) {
							System.out.println("Enter valid input");
						}
						System.out.println("Enter end date");
						try {
							System.out.println("Enter end year");
							int year = sc.nextInt();
							System.out.println("Enter end month");
							int month = sc.nextInt();
							System.out.println("Enter end dayOfTheMonth");
							int day = sc.nextInt();
							p1.setEndDate(LocalDate.of(year, month, day));
						}catch(Exception e) {
							System.out.println("Enter valid input");
						}
						proService.createProject(p1);
						break;
					case 13:
						Salary s3 = new Salary();
						System.out.println("Enter salary id");
						s3.setSalaryId(sc.nextInt());
						System.out.println("Enter salary amount");
						s3.setSalaryAmount(sc.nextDouble());
						System.out.print("");
						s3.setCurrency(sc.nextLine());
						System.out.println("Enter salary currency");
						s3.setCurrency(sc.nextLine());
						System.out.println("Enter salary payment date");
						try {
							System.out.println("Enter payment year");
							int year = sc.nextInt();
							System.out.println("Enter payment month");
							int month = sc.nextInt();
							System.out.println("Enter payment dayOfTheMonth");
							int day = sc.nextInt();
							s3.setPaymentDate(LocalDate.of(year, month, day));
						}catch(Exception e) {
							System.out.println("Enter valid input");
						}
						salService.createSalary(s3);
						break;
					case 14:
						System.out.println("Enter employee id");
						Employee e =  empService.getEmployeeD(sc.nextInt());
						System.out.println("Enter project id to set project to employee");
						e.setProject(proService.getProjectD(sc.nextInt()));
						System.out.println("Enter domain id to set domain to employee");
						e.setDomain(domService.getDomainD(sc.nextInt()));
						System.out.println("Enter salary id to set salary to employee");
						e.setSalary(salService.getSalaryD(sc.nextInt()));
						empService.updateEmploye(e);
						break;
					case 15:
						System.out.println("Enter domain id");
						Domain d = domService.getDomainD(sc.nextInt());
						System.out.println("Enter employee id to set employee to domain");
						d.getEmployee().add(empService.getEmployeeD(sc.nextInt()));
						domService.updateDomain(d);
						break;
					case 16:
						System.out.println("Enter project id");
						Project p = proService.getProjectD(sc.nextInt());
						System.out.println("Enter employee id to add as manager to project");
						p.getEmployee().add(empService.getEmployeeD(sc.nextInt()));
						proService.updateProject(p);
						break;
					case 17:
						System.out.println("Enter salary id");
						Salary s = salService.getSalaryD(sc.nextInt());
						System.out.println("Enter employee id to add employee to salary");
						s.setEmployee(empService.getEmployeeD(sc.nextInt()));
						salService.updateSalary(s);
						break;
					case 18:
						System.out.println("Enter employee id");
						try {
							empService.deleteEmployee(empService.getEmployeeD(sc.nextInt()));
							System.out.println("employee deleted successfully");
						}catch(Exception exp) {
							System.out.println("Data not deleted due to foreign key references");
						}
						break;
					case 19:
						System.out.println("Enter domain id");
						try {
							domService.deleteDomain(domService.getDomainD(sc.nextInt()));
							System.out.println("domain deleted successfully");
						}catch(Exception exp) {
							System.out.println("Data not deleted due to foreign key references");
						}
						break;
					case 20:
						System.out.println("Enter salary id");
						try {
							salService.deleteSalary(salService.getSalaryD(sc.nextInt()));
							System.out.println("salary deleted successfully");
						}catch(Exception exp) {
							System.out.println("Data not deleted due to foreign key references");
						}
						break;
					case 21:
						System.out.println("Enter project id");
						try {
							proService.deleteProject(proService.getProjectD(sc.nextInt()));
							System.out.println("project deleted successfully");
						}catch(Exception exp) {
							System.out.println("Data not deleted due to foreign key references");
						}
						break;
					default:
						System.out.println("Enter valid Input");
						break;
				}
			}else {
				System.out.print("Ener valid input");
				System.exit(0);
			}
		}
		
		
		
	}

}


/*
 		StandardServiceRegistry ssregistry=new StandardServiceRegistryBuilder().configure("Config.xml").build();
		Metadata metadata=new MetadataSources(ssregistry).getMetadataBuilder().build();
		
		
		SessionFactory sfactory=metadata.buildSessionFactory();
		
		Session session=sfactory.openSession();
		Transaction transaction=session.beginTransaction();
 		Employee e1 = new Employee();
		e1.setEmployeeId(1);
		e1.setFirstName("Chethan");
		e1.setLastName("Kumar");
		e1.setEmail("chethan@gmail.com");
		e1.setPhoneNo("6305784279");
		e1.setHireDate(LocalDate.of(2023, 07, 22));
		e1.setJobTitle("Junior H.R");
		
		
		Employee e2 = new Employee();
		e2.setEmployeeId(2);
		e2.setFirstName("Yogesh");
		e2.setLastName("Kumar");
		e2.setEmail("yogesh@gmail.com");
		e2.setPhoneNo("6305784278");
		e2.setHireDate(LocalDate.of(2023, 07, 21));
		e2.setJobTitle("Backend Developer");
		
		
		Employee e3 = new Employee();
		e3.setEmployeeId(3);
		e3.setFirstName("Amith");
		e3.setLastName("Kumar");
		e3.setEmail("amith@gmail.com");
		e3.setPhoneNo("6305784277");
		e3.setHireDate(LocalDate.of(2023, 07, 20));
		e3.setJobTitle("Java Developer");
		
		
		Domain d1 = new Domain();
		d1.setDomainId(1);
		d1.setDomainName("H.R");
		
		Domain d2 = new Domain();
		d2.setDomainId(2);
		d2.setDomainName("I.T");
		
		
		e1.setDomain(d1);
		e2.setDomain(d2);
		e3.setDomain(d2);
		
		//setting employees to domain
		d1.getEmployee().add(e1);
		d2.getEmployee().add(e2);
		d2.getEmployee().add(e3);
		
		//setting salary
		Salary s1 = new Salary();
		s1.setSalaryId(1);
		s1.setEmployee(e1);
		s1.setSalaryAmount(30000.00);
		s1.setCurrency("rupees");
		s1.setPaymentDate(LocalDate.of(2024, 2, 1));
		
		Salary s2 = new Salary();
		s2.setSalaryId(2);
		s2.setEmployee(e2);
		s2.setSalaryAmount(30000.00);
		s2.setCurrency("rupees");
		s2.setPaymentDate(LocalDate.of(2024, 2, 1));
		
		Salary s3 = new Salary();
		s3.setSalaryId(3);
		s3.setEmployee(e3);
		s3.setSalaryAmount(30000.00);
		s3.setCurrency("rupees");
		s3.setPaymentDate(LocalDate.of(2024, 2, 1));
		
		
		
		Project p1 = new Project();
		p1.setProjectId(1);
		p1.setProjectName("Delivey Application");
		p1.setStartDate(LocalDate.of(2024, 02, 12));
		p1.setEndDate(LocalDate.of(2024, 05, 30));
		
		
		//setting project
		p1.getEmployee().add(e1);
		p1.getEmployee().add(e2);
		p1.getEmployee().add(e3);
		//setting project manager
		p1.setManagerId(e1);
		
		//setting salary to employee
		e1.setSalary(s1);
		e2.setSalary(s2);
		e3.setSalary(s3);
		
		
		
		session.persist(e1);
		session.persist(e2);
		session.persist(e3);
		
		session.persist(s3);
		session.persist(s2);
		session.persist(s1);
		
		session.persist(d1);
		session.persist(d2);
		
		session.persist(p1);
		
		e1.setProject(p1);
		e2.setProject(p1);
		e3.setProject(p1);
		
		
		transaction.commit();
		session.close();
		sfactory.close();
  
  
 */

