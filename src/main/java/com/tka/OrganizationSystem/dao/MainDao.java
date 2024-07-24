package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {
	
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
		
	 session=	factory.openSession();
	tx= session.beginTransaction();
	 
	session.persist(c);
	tx.commit();
		msg="Country is Added...";
	}catch(Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
			
		}
	}
	return msg; 
	}

	public String updateCountry(int id, Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Country country=session.get(Country.class,id);
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			
			msg="Country is updated...";
			
			
		}catch(Exception e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public Country getParticularRecord(int id) {

		Session session=null;
		Transaction tx=null;
		Country c=null;
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			c= session.get(Country.class, id);
			tx.commit();
		}
		catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return c;
		
		
	}
	
	public List<Country> getAllCountry() {
		
		String hqlQuery="from Country";
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		Query<Country> query= session.createQuery(hqlQuery,Country.class);
		
		List<Country> list=query.list();
		
		session.getTransaction().commit();
		session.close();
		return list;
	}
	

	public String addEmployee(Employee emp) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			session.persist(emp);
			tx.commit();
			
			msg="Employee Added Successfully...";
			
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String updateEmployee(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee employee=session.get(Employee.class,emp.getId());
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreatedby(emp.getCreatedby());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setEmailid(emp.getEmailid());
			employee.setDepartment(emp.getDepartment());
			employee.setStatus(emp.getStatus());
			employee.setSalary(emp.getSalary());
			employee.setPhoneno(emp.getPhoneno());
			
			session.merge(employee);
			tx.commit();
			
			msg="Employee is updated...";
			
			
		}catch(Exception e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		return msg;

	

}

	public String deleteEmployee(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee emp= session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg="Employee is Deleted...";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			
			if(session!=null) {
				session.close();
			}
			
		}
		return msg;
		
	}

	public List<Employee> getAllEmployee() {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuey="from Employee";		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query= 
			session.createQuery(hqlQuey,Employee.class);
			list= query.list();
			tx.commit();
		}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
				
			}finally {
				
				if(session!=null) {
					session.close();
				}
			}	
		return list;
	}

	public Employee getParticularById(int id) {
		
		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
		emp= session.get(Employee.class, id);
			tx.commit();
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}	
		return emp;
	}

	public List<Employee> getEmployeeByStatus(String status) {
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuey="from Employee where status=:mystatus";		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query= 
			session.createQuery(hqlQuey,Employee.class);
			
//			query.setParameter("mystatus", status);
//			
			
			query.setParameter("mystatus", status);
			list= query.list();
			tx.commit();
		}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
				
			}finally {
				
				if(session!=null) {
					session.close();
				}
			}	
		
		return list;
	}

	
	public Employee loginCheck(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		Employee employee=null;
		String hqlQuey="from Employee where emailid=:myemailid and phoneno=:myphone";	
		
		try {
			
			session = factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query= session.createNamedQuery(hqlQuey,Employee.class);
			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("myphone", emp.getPhoneno());
			
			employee=query.uniqueResult();
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			
				if(session!=null) {
					session.close();
				}
		}
		
		return employee;


		
	}



	
}
