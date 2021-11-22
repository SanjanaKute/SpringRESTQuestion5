package com.SpringRestQuestion5.SpringRestEmployee.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.SpringRestQuestion5.SpringRestEmployee.Entity.Employee;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	
	List<Employee> list;
	public EmployeeServicesImpl()
	{
		list=new ArrayList<>();
		list.add(new Employee(1,"John","HR","Associate",50000));
		list.add(new Employee(2,"Alex","IT","Head of Department",70000));
		list.add(new Employee(3,"Garry","Finance","Manager",60000));
		list.add(new Employee(4,"Silver","Marketing","Associate Manager",20000));
		list.add(new Employee(5,"Jack","Research","Assistance",25000));

	}
	
	@Override
	public List<Employee> getEmployees()
	{	
		return list;
	}

	@Override
	public Employee getEmployee(long employeeId) {

		Employee e=null;
		for (Employee employee : list)
		{
			if(employee.getEmployeeId()==employeeId)
			{
				e=employee;
				break;
			}
			
		}
		
		return e;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		list.add(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		list.forEach(e ->
		{
			if(e.getEmployeeId()==employee.getEmployeeId())
			{
				e.setEmployeeSalary(employee.getEmployeeSalary());
			}
		});
		return employee;
	}

	@Override
	public void deleteEmployee(long employeeId) {

		list=this.list.stream().filter(e->e.getEmployeeId()!=employeeId).collect(Collectors.toList());
	}

	

	

}
