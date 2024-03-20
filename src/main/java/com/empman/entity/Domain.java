package com.empman.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Domain")
public class Domain {
	@Id	
	private Integer domainId;
	private String domainName;
	
	@OneToMany(mappedBy = "domain", cascade = CascadeType.ALL)
	List<Employee> employee = new ArrayList<Employee>();
	
	

	public Domain() {
		super();
	}



	public Domain(Integer domainId, String domainName, List<Employee> employee) {
		super();
		this.domainId = domainId;
		this.domainName = domainName;
		this.employee = employee;
	}



	public Integer getDomainId() {
		return domainId;
	}



	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}



	public String getDomainName() {
		return domainName;
	}



	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}



	public List<Employee> getEmployee() {
		return employee;
	}



	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}



	@Override
	public String toString() {
		return "Domain \n[domainId=" + domainId + ", domainName=" + domainName + ", employee=" + employee + "]";
	}
	
	
}
