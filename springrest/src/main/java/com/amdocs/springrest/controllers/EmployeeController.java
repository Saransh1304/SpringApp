package com.amdocs.springrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.springrest.model.Employee;
import com.amdocs.springrest.services.EmployeeServices;


@RestController
public class EmployeeController {
	
	@Autowired 
	EmployeeServices employeeServices;
	
	@GetMapping("/")
	public List<Employee> getAllEmployees()
	{
		return employeeServices.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id)
	{
		Employee emp = employeeServices.getEmployeeById(id);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/")
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee e)
	{
		Employee emp = employeeServices.insertEmployee(e);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/emp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody  Employee e)
	{
		System.out.println("Sara");
		Employee emp = employeeServices.updateEmployee(e);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") int id)
	{
		String s = employeeServices.deleteEmployeeById(id);
		ResponseEntity<String> re  = new ResponseEntity<String>(s, HttpStatus.OK);
		return re;
	}

}

