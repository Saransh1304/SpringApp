package com.amdocs.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.springrest.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}