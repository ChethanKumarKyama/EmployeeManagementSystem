package com.empman.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Salary")
public class Salary {
	@Id
	private Integer salaryId;
	private Double salaryAmount;
	private String currency;
	private LocalDate paymentDate;
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;

	public Salary() {
		super();
	}

	public Salary(Integer salaryId, Double salaryAmount, String currency, LocalDate paymentDate, Employee employee) {
		super();
		this.salaryId = salaryId;
		this.salaryAmount = salaryAmount;
		this.currency = currency;
		this.paymentDate = paymentDate;
		this.employee = employee;
	}

	public Integer getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Integer salaryId) {
		this.salaryId = salaryId;
	}

	public Double getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(Double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", salaryAmount=" + salaryAmount + ", currency=" + currency
				+ ", paymentDate=" + paymentDate + ", employee=" + employee.getFirstName() +" "+employee.getLastName()+ "]";
	}
	
	
	
}
