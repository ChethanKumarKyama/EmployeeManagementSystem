package com.empman;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.empman.service.DomainService;
import com.empman.service.EmployeeService;
import com.empman.service.ProjectService;
import com.empman.service.SalaryService;
import com.empman.serviceImpl.DomainServiceImpl;
import com.empman.serviceImpl.EmployeeServiceImpl;
import com.empman.serviceImpl.ProjectServiceImpl;
import com.empman.serviceImpl.SalaryServiceImpl;

public class EmpMangementImplTest {


	EmployeeService empService = new EmployeeServiceImpl(); 
	DomainService domService = new DomainServiceImpl();
	ProjectService proService = new ProjectServiceImpl(); 
	SalaryService salService = new SalaryServiceImpl();
	
	@Test
	public void employeeTest() {
		assertEquals("1", empService.getEmployeeD(1).getEmployeeId().toString());
		assertEquals("Chethan", empService.getEmployeeD(1).getFirstName());
		assertEquals("Kumar", empService.getEmployeeD(1).getLastName());
		assertEquals(LocalDate.of(2023, 07, 22), empService.getEmployeeD(1).getHireDate());
		assertEquals("chethan@gmail.com", empService.getEmployeeD(1).getEmail());
		assertEquals("Junior H.R", empService.getEmployeeD(1).getJobTitle());
		assertEquals("6305784279", empService.getEmployeeD(1).getPhoneNo());
		assertEquals("1", empService.getEmployeeD(1).getDomain().getDomainId().toString());
		assertEquals("1", empService.getEmployeeD(1).getProject().getProjectId().toString());
		assertEquals("1", empService.getEmployeeD(1).getSalary().getSalaryId().toString());
	}
	
	@Test
	public void domainTest() {
		assertEquals("1",domService.getDomainD(1).getDomainId().toString());
		assertEquals("H.R",domService.getDomainD(1).getDomainName());
		assertEquals("2",domService.getDomainD(2).getDomainId().toString());
		assertEquals("I.T",domService.getDomainD(2).getDomainName());
	}
	
	@Test
	public void projectTest() {
		assertEquals("1", proService.getProjectD(1).getProjectId().toString());
		assertEquals(LocalDate.of(2024, 05, 30), proService.getProjectD(1).getEndDate());
		assertEquals("Delivey Application", proService.getProjectD(1).getProjectName());
		assertEquals(LocalDate.of(2024, 02, 12), proService.getProjectD(1).getStartDate());
	}
	
	@Test
	public void salarytest() {
		assertEquals("1", salService.getSalaryD(1).getSalaryId().toString());
		assertEquals("rupees", salService.getSalaryD(1).getCurrency());
		assertEquals(LocalDate.of(2024, 02, 01), salService.getSalaryD(1).getPaymentDate());
		assertEquals("30000.0", salService.getSalaryD(1).getSalaryAmount().toString());
		assertEquals("1", salService.getSalaryD(1).getEmployee().getEmployeeId().toString());
	}

}
