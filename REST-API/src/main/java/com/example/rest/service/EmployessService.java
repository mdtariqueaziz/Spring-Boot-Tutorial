package com.example.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rest.entity.Employee;

@Service
public class EmployessService {

	public static List<Employee> employee = new ArrayList<Employee>();
	static {
		employee.add(new Employee(03, "Tarique", "Gaya"));
		employee.add(new Employee(04, "Azhar", "Patna"));
		employee.add(new Employee(05, "Karan", "Hyderabad"));

	}

	public List<Employee> getAllEmployee() {

		return employee;
	}

	public Employee getEmployee(int id) {
		Employee emp = null;
		try {

			emp = employee.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return emp;
	}

	public void updateEmployee(int id, Employee e) {
		employee = employee.stream().map(b -> {
			if (b.getId() == id) {
				b.setName(e.getName());
				b.setAddress(e.getAddress());

			}
			return b;

		}).collect(Collectors.toList());

	}

	public Employee addEmployee(Employee e) {
		employee.add(e);
		return e;

	}

	// Delete one Employee
	public void deleteEmployee(Employee e) {
		  employee.remove(e);
		
	}

}
