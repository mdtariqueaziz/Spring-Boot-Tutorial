package com.example.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Project project;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String name, String address, Project project) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.address = address;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", address=" + address + ", project=" + project + "]";
	}

}
