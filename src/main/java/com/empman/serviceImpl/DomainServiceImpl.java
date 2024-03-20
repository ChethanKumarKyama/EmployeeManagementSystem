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

import com.empman.entity.Domain;
import com.empman.service.DomainService;

public class DomainServiceImpl implements DomainService {
	
	StandardServiceRegistry ssregistry=new StandardServiceRegistryBuilder().configure("Config.xml").build();
	Metadata metadata=new MetadataSources(ssregistry).getMetadataBuilder().build();
	
	
	SessionFactory sfactory=metadata.buildSessionFactory();
	
	Session session;
	Transaction transaction;

	public void createDomain(Domain domain) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.save(domain);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void deleteDomain(Domain domain) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.delete(domain);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void updateDomain(Domain domain) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(domain);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void getDomains() {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			TypedQuery tq1 = session.createQuery("from Domain");
			List<Domain> domains = tq1.getResultList();
			Iterator<Domain> itr = domains.iterator(); 
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}finally {
			session.close();
		}
	}
	
	public void getDomain(int id) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			Domain domain = session.get(Domain.class, id);
			System.out.println(domain);
		}finally {
			session.close();
		}
		
	}

	public Domain getDomainD(int id) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			Domain domain = session.get(Domain.class, id);
			return domain;
		}finally {
			session.close();
		}
	}


}
