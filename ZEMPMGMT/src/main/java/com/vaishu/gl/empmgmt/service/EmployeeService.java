package com.vaishu.gl.empmgmt.service;

import java.util.List;

import com.vaishu.gl.empmgmt.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int id);

	public void saveOrUpdate(Employee employee);

	public void deleteById(int id);
	
	
}
