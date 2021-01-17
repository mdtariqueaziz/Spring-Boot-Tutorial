package com.example.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.dao.EmployeeRepository;
import com.example.rest.entity.Employee;

@Service
public class EmployessService {

//	public static List<Employee> employee = new ArrayList<Employee>();
//	static {
//		employee.add(new Employee(03, "Tarique", "Gaya"));
//		employee.add(new Employee(04, "Azhar", "Patna"));
//		employee.add(new Employee(05, "Karan", "Hyderabad"));
//
//	}

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		return employees;
	}

	public Employee getEmployee(int id) {
		Employee emp = null;
		try {

			Employee emp2 = employeeRepository.findById(id);
			return emp2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;

	}

	public void updateEmployee(int id, Employee e) {
		e.setEmp_id(id);
		employeeRepository.save(e);

	}

	public Employee addEmployee(Employee e) {
		Employee saveEmp = employeeRepository.save(e);
		return saveEmp;

	}

	// Delete one Employee
	public void deleteEmployee(Employee e) {
		employeeRepository.delete(e);

	}

}
