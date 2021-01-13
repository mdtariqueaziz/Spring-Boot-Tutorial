package com.example.com;

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
		ConfigurableApplicationContext context =  SpringApplication
				.run(JpaWithSpringBootApplication.class, args);

		StudentRepo studentRepo = (StudentRepo)((BeanFactory) context).getBean(StudentRepo.class);
		
        Student student = new Student();
        student.setName("Tarique");
        student.setCity("Bodhgaya");
        student.setStatus("I am a Student");
        
        Student student2 = studentRepo.save(student);
        System.out.println(student2);
		
		

	}

}
