package com.vaishu.gl.empmgmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vaishu.gl.empmgmt.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	
    EntityManager entityManager;
	
    
    @Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		 Employee employee =  currentSession.get(Employee.class, id);
		return null;
	}

	
	@Transactional
	public void saveOrUpdate(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		 currentSession.saveOrUpdate(currentSession);
		
	}


	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = findById(id);
		 currentSession.delete(employee);
		
	}

	
	
}
