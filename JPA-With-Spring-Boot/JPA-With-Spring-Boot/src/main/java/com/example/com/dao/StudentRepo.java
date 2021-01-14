package com.example.com.dao;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.com.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	public List<Student> findByNameAndCity(String name, String city);

	public List<Student> findByCityStartingWith(String city);

	// JPQL
	@Query("select s from Student s")
	public List<Student> getAllStudent();

	@Query("select s from Student s where s.name=:n and s.city=:c")
	public List<Student> getStudentByName(@Param("n") String name, @Param("c") String city);

	// SQL Native Query
	@Query(value = "select * from student5", nativeQuery = true)
	public List<Student> getAllStudentN();

}
