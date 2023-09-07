package com.amdocs.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.springrest.exceptions.EmployeeNotFound;
import com.amdocs.springrest.model.Employee;
import com.amdocs.springrest.repository.EmployeeRepository;


@Service
public class EmployeeServices {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> obj = employeeRepository.findById(id);
		if(obj.isPresent())
			return obj.get();		
		else
			throw new EmployeeNotFound("No Employee Found with id: "+ id);
	}
	
	public Employee insertEmployee(Employee e)
	{
		employeeRepository.save(e);
		return e;
	}
	
	public Employee updateEmployee(Employee e)
	{
		if(employeeRepository.existsById(e.getId()))
		{
			Employee dbE=employeeRepository.findById(e.getId()).get();
			dbE.setfName(e.getfName());
			dbE.setlName(e.getlName());
			dbE.setEmail(e.getEmail());
			employeeRepository.save(dbE);
			return e;
		}
		else
		{
			throw new EmployeeNotFound("No Employee Exists with ID: "+ e.getId());
		}
	}
	
	public String deleteEmployeeById(int id)
	{
		if(employeeRepository.existsById(id))
		{
			employeeRepository.deleteById(id);
			return "SUCCESS";
		}
		else
		{
			throw new EmployeeNotFound("No Employee Exists with ID: "+ id);
		}
			
	}

}
