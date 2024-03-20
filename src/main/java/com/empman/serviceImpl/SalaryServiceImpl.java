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

import com.empman.entity.Salary;
import com.empman.service.SalaryService;

public class SalaryServiceImpl implements SalaryService {

	StandardServiceRegistry ssregistry=new StandardServiceRegistryBuilder().configure("Config.xml").build();
	Metadata metadata=new MetadataSources(ssregistry).getMetadataBuilder().build();
	
	
	SessionFactory sfactory=metadata.buildSessionFactory();
	
	Session session;
	Transaction transaction;
	
	public void createSalary(Salary salary) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.save(salary);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void deleteSalary(Salary salary) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.delete(salary);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void updateSalary(Salary salary) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(salary);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void getSalary(int id) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			Salary salary = session.get(Salary.class, id);
			System.out.println(salary);
		}finally {
			session.close();
		}
	}

	public void getSalaries() {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			TypedQuery tq = session.createQuery("from Salary");
			List<Salary> salaries = tq.getResultList();
			Iterator<Salary> itr = salaries.iterator(); 
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}finally {
			session.close();
		}
	}

	public Salary getSalaryD(int id) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			Salary salary = session.get(Salary.class, id);
			return salary;
		}finally {
			session.close();
		}
	}

}
