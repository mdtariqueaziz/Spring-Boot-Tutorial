package com.example.rest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.rest.entity.Employee;

@Service
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public List<Employee> findAll();

	public Employee findById(int id);

}
