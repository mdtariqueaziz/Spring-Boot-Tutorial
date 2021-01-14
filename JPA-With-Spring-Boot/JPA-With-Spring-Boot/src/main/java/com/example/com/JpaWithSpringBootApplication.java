package com.example.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.com.dao.StudentRepo;
import com.example.com.entity.Student;

@SpringBootApplication
public class JpaWithSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaWithSpringBootApplication.class, args);

		StudentRepo studentRepo = (StudentRepo) ((BeanFactory) context).getBean(StudentRepo.class);

		Student student = new Student();
		student.setName("Tarique");
		student.setCity("Bodhgaya");
		student.setStatus("I am a Student");

		Student student2 = new Student();
		student2.setName("Samad");
		student2.setCity("Gaya");
		student2.setStatus("I am a python Developer");

		// Insert single object
//		Student result = studentRepo.save(student);
//		System.out.println(result);

		// Insert multiple object
//		List<Student> students = new ArrayList<Student>();
//		students.add(student);
//		students.add(student2);
//		Iterable<Student> result2 = studentRepo.saveAll(students);
//
//		result2.forEach(res -> {
//			System.out.println(res);
//		});

		// Find by id
//		Optional<Student> findById = studentRepo.findById(6);
//		System.out.println(findById);
//      Find All
//		List<Student> list = studentRepo.findAll();
//		list.forEach(res -> {
//			System.out.println(res);
//		});
		// Update
//		Optional<Student> optional = studentRepo.findById(6);
//		Student student3 = optional.get();
//		student3.setName("Aziz");
//		Student res = studentRepo.save(student3);
//		System.out.println(res);

		// Delete by Id
//		studentRepo.deleteById(7);
//		System.out.println("Student deleted succesfully");

		// Delete All
//		studentRepo.deleteAll();
//		System.out.println("All record deleted successfully");

//		/// Custome methods
//		List<Student> findByNameAndCity = studentRepo.findByNameAndCity("Karan", "Patna");
//		findByNameAndCity.forEach(data -> {
//			System.out.println(data);
//		});

//		List<Student> findByCityStartingWith = studentRepo.findByCityStartingWith("G");
//		findByCityStartingWith.forEach(e -> {
//			System.out.println(e);
//		});

//		studentRepo.getAllStudent().forEach(e -> {
//			System.out.println(e);
//		});

//		studentRepo.getStudentByName("Karan", "patna").forEach(e -> {
//			System.out.println(e);
//		});

		studentRepo.getAllStudentN().forEach(e -> {
			System.out.println(e);
		});

	}

}
