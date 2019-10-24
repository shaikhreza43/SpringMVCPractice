package org.zs.employee.dao;

import org.hibernate.Transaction;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zs.employee.dto.EmployeeDto;

@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	Session session = null;
	Transaction transaction = null;

	public Integer saveNewUserDataInDb(EmployeeDto employeeData) {
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Integer identifier= (Integer) session.save(employeeData);
			transaction.commit();
			if(identifier == null) {
				System.err.println("Data Couldn't be saved!");
				return identifier;
			}
			else {
				System.out.println("Data Saved Successfully.");
				return identifier;
			}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally {
			if(session!=null)
				session.close();
		}
		return null;
		
	}

}
