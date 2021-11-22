package com.SpringRestQuestion5.SpringRestEmployee.Services;

import java.util.List;

import com.SpringRestQuestion5.SpringRestEmployee.Entity.Employee;

public interface EmployeeServices {


	public List<Employee>getEmployees();


	public Employee getEmployee(long employeeId);


	public Employee addEmployee(Employee employee);
	
	public void deleteEmployee(long employeeId);


	Employee updateEmployee(Employee employee);
	
	



}
