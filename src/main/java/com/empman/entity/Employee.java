package com.empman.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "Employee")

public class Employee {
	@Id
	@PrimaryKeyJoinColumn
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private LocalDate hireDate;
	private String jobTitle;
	
	@ManyToOne
	@JoinColumn(name = "domainId")
	private Domain domain;
	
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;
	
	@OneToOne(targetEntity = Salary.class, cascade = CascadeType.ALL)
	private Salary salary;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String firstName, String lastName, String email, String phoneNo,
			LocalDate hireDate, String jobTitle, Domain domain, Project project, Salary salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.hireDate = hireDate;
		this.jobTitle = jobTitle;
		this.domain = domain;
		this.project = project;
		this.salary = salary;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNo=" + phoneNo + ", hireDate=" + hireDate + ", jobTitle=" + jobTitle + ", domain="
				+ domain.getDomainName() + ", project=" + project.getProjectName() + ", salary=" + salary.getSalaryAmount() + "]";
	}


	
	
	
	
	
}
