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
import com.empman.entity.Project;
import com.empman.entity.Salary;
import com.empman.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	
	StandardServiceRegistry ssregistry=new StandardServiceRegistryBuilder().configure("Config.xml").build();
	Metadata metadata=new MetadataSources(ssregistry).getMetadataBuilder().build();
	
	
	SessionFactory sfactory=metadata.buildSessionFactory();
	
	Session session;
	Transaction transaction;
	
	public void createProject(Project project) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.save(project);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void deleteProject(Project project) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.delete(project);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(project);
		}finally {
			transaction.commit();
			session.close();
		}
	}

	public void getProject(int id) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			Project project = session.get(Project.class, id);
			System.out.println(project);
		}finally {
			session.close();
		}
	}
	
	public Project getProjectD(int id) {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			Project project = session.get(Project.class, id);
			return project;
		}finally {
			session.close();
		}
	}

	public void getProjects() {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			TypedQuery tq = session.createQuery("from Project");
			List<Project> salaries = tq.getResultList();
			Iterator<Project> itr = salaries.iterator(); 
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}finally {
			session.close();
		}
	}

	public void getprojectMembers() {
		// TODO Auto-generated method stub
		try {
			session=sfactory.openSession();
			String hql = "SELECT CONCAT(e.firstName, ' ', e.lastName, ' is assigned for the project: ', p.projectName) AS projectManager " + "FROM Employee e " +"INNER JOIN e.project p";

			TypedQuery<String> query = session.createQuery(hql, String.class);
			List<String> projectManagers = query.getResultList();
			Iterator<String> itr = projectManagers.iterator(); 
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}finally {
			session.close();
		}
	}

	

}
