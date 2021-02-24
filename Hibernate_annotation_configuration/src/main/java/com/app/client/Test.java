package com.app.client;

import org.hibernate.Session;

import com.app.entity.Employee;
import com.app.utility.HibernateUtility;

public class Test {
	
	public void save() {
		Session session=HibernateUtility.getSession().openSession();
		Employee emp=new Employee();
		emp.setName("Vinaya");
		emp.setMobile("986436224");
		emp.setSalary(4000d);
		emp.setAge(32);
		session.save(emp);
		session.beginTransaction().commit();
		System.out.println("Success");
		
	}
	
	
	public void updateVersion() {
		Session session=HibernateUtility.getSession().openSession();
		Employee emp=(Employee)  session.get(Employee.class , 1);
		emp.setAge(20);
		session.update(emp);
		session.beginTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public void selectAll() {
		HibernateUtility.getSession().openSession().createCriteria(Employee.class).list().forEach(System.out::println);
	}
	
	
	@SuppressWarnings("unchecked")
	public void findAllEmployees() {
		Session session=HibernateUtility.getSession().openSession();
		session.getNamedQuery("find All").list().forEach(System.out::println);
		System.out.println("--------------------------------------------");
		session.getNamedQuery("findByName").setParameter("ename", "Vinaya").list().forEach(System.out::println);
		session.close();
	}

	
	public static void main(String[] args) {
		Test t=new Test();
		//t.save();
		t.updateVersion();
		t.selectAll();
		//t.findAllEmployees();
	}
}
