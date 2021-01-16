package com.example.rest.controler;

import java.util.List;
import java.util.Optional;

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

import com.example.rest.entity.Employee;
import com.example.rest.service.EmployessService;

@RestController
public class controler {

	@Autowired(required = true)
	EmployessService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = employeeService.getAllEmployee();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployee(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee));

	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
		Employee addEmployee = null;
		try {
			addEmployee = employeeService.addEmployee(e);
			return ResponseEntity.of(Optional.of(addEmployee));
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {
		Employee updateEmp = null;
		try {

			updateEmp = employeeService.addEmployee(e);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

	// Update by Id
	@PutMapping("/employees/{id}")
	public Employee updateByIdEmp(@RequestBody Employee e, @PathVariable("id") int id) {
		employeeService.updateEmployee(id, e);
		return e;
	}

	// Delete one employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
		Employee emp = null;
		try {
			emp = employeeService.getEmployee(id);
			employeeService.deleteEmployee(emp);
			ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;

	}

}