package com.example.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Poject")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	private int project_id;
	@Column(name = "name")
	private String name;
	@Column(name = "project_manager")
	private String project_manager;
	
	@JsonBackReference
	@OneToOne(mappedBy="project")
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int project_id, String name, String project_manager) {
		super();
		this.project_id = project_id;
		this.name = name;
		this.project_manager = project_manager;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProject_manager() {
		return project_manager;
	}

	public void setProject_manager(String project_manager) {
		this.project_manager = project_manager;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", name=" + name + ", project_manager=" + project_manager + "]";
	}

}
