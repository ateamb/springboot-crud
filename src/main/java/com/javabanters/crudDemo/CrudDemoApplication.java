package com.javabanters.crudDemo;

import com.javabanters.crudDemo.dao.StudentDAO;
import com.javabanters.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			readAllStudents(studentDAO);
			//updateStudent(studentDAO);
			//readByLastName(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int number= studentDAO.deleteAll();
		System.out.println("Number of students deleted "+ number);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Integer id = 3;
		System.out.println("Deleting student with id "+id);
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Integer id = 2;
		Optional<Student> student = studentDAO.findById(id);
		System.out.println("Found student "+ student);
		student.get().setLastName("Rai");
		System.out.println("Updating last name");
		Student updatedStudent = studentDAO.update(student.get());
		System.out.println("The new updated student is"+ updatedStudent);
	}

	private void readByLastName(StudentDAO studentDAO) {
		System.out.println("Getting student by last name");
		List<Student> students = studentDAO.findByLastName("Rai");
		for(Student s: students){
			System.out.println(s);
		}
	}

	private void readAllStudents(StudentDAO studentDAO) {
		System.out.println("Getting all students");
		List<Student> students = studentDAO.findAll();
		for(Student s: students) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Displaying the student with id 2");
		Optional<Student> student = studentDAO.findById(4);
		System.out.println(student.isPresent() ? student : "The student doesn't exists");
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student....");
		Student student1 = new Student("Priyanka","Rai","pik@javabanters.com");
		Student student2 = new Student("Santhi","Gurung","san@javabanters.com");
		Student student3 = new Student("Dolker","Lama","dol@javabanters.com");


		System.out.println("Saving the students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		List<Student> students = List.of(student1,student2,student3);

		for(Student s : students) {
			System.out.println("The student is created with id: "+s.getId());
		}

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student....");
		Student student1 = new Student("Anant","Majhi","anmajhi@javabanters.com");

		studentDAO.save(student1);

		System.out.println("The student is created with id: "+student1.getId());
	}
}
