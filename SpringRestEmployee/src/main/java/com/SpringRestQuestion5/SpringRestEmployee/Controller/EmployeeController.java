package com.SpringRestQuestion5.SpringRestEmployee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRestQuestion5.SpringRestEmployee.Entity.Employee;
import com.SpringRestQuestion5.SpringRestEmployee.Services.EmployeeServices;

@RestController
public class EmployeeController
{
	@Autowired 
	private EmployeeServices employeeServices;
	
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome";
	}
	
	@GetMapping("/employees")      //localhost:8080/employees
	public List<Employee>getEmployees()
	{
		return this.employeeServices.getEmployees();
		
	}
	@GetMapping("/employees/{employeeId}")      //localhost:8080/employees/1
	public Employee getEmployee(@PathVariable String employeeId)
	{
		return this.employeeServices.getEmployee(Long.parseLong(employeeId));
	}
	
	@PostMapping("/employees")                 //GET //localhost:8080/employees
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return this.employeeServices.addEmployee(employee);
	}
	
	@PutMapping("/employees") 
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return this.employeeServices.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{employeeId}")  
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId )
	{ try
	{
		this.employeeServices.deleteEmployee(Long.parseLong(employeeId));
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	catch(Exception e)
	{
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
}
