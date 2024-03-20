package com.empman.serviceImpl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.empman.entity.Employee;
import com.empman.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	StandardServiceRegistry ssregistry=new StandardServiceRegistryBuilder().configure("Config.xml").build();
	Metadata metadata=new MetadataSources(ssregistry).getMetadataBuilder().build();
	
	
	SessionFactory sfactory=metadata.buildSessionFactory();
	
	Session session;
	Transaction transaction;

	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.save(employee);
		}finally{
			transaction.commit();
			session.close();
		}
		
	}

	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.delete(employee);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void updateEmploye(Employee employee) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(employee);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void getEmployee(int id) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			Employee employee = session.get(Employee.class, id);
			System.out.println(employee);
		}finally {
			session.close();
		}
		
	}
	
	public Employee getEmployeeD(int id) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			Employee employee = session.get(Employee.class, id);
			return employee;
		}finally {
			session.close();
		}
		
	}

	public void getEmployees() {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			TypedQuery tq = session.createQuery("from Employee");
			List<Employee> employees = tq.getResultList();
			Iterator<Employee> itr = employees.iterator(); 
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}finally {
			session.close();
		}
	}

	

	

	

}
