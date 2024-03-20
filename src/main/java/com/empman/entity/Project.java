package com.empman.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Project")
public class Project {
	@Id
	private Integer projectId;
	private String projectName;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
	private Employee managerId;
	
	@OneToMany(mappedBy =  "project", cascade = CascadeType.ALL)
	List<Employee> employee = new ArrayList<Employee>();

	public Project() {
		super();
	}

	public Project(Integer projectId, String projectName, LocalDate startDate, LocalDate endDate, Employee managerId,
			List<Employee> employee) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerId = managerId;
		this.employee = employee;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Employee getManagerId() {
		return managerId;
	}

	public void setManagerId(Employee managerId) {
		this.managerId = managerId;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", managerId=" + managerId + ", employee=" + employee + "]";
	}
	
	
	
}
