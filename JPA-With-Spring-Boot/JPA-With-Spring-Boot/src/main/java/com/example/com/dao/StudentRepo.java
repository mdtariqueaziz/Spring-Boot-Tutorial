package com.example.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.com.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
