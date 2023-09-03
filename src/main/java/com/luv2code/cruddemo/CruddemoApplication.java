package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);
			//readstudent(studentDAO);
			//queryForStudent(studentDAO);
			findbylastname(studentDAO);

		};
	}

	private void findbylastname(StudentDAO studentDAO) {
		{
			List<Student> theans=studentDAO.findByLast("Duck");
			for(var k:theans)
			{
				System.out.println(k);
			}
		}
	}


	private void queryForStudent(StudentDAO studentDAO) {
		// get the list of student
		List<Student> thestudents= studentDAO.findAll();
		// dispaly the list of student
		for( var i : thestudents)
		{
			System.out.println(i);
		}



	}

	private void readstudent(StudentDAO studentDAO) {

		// create a new student
		System.out.println("Creating a new object ");
		Student temp1student= new Student("daffy","duck", "daffy@gmail.com");
		// save the obj
		System.out.println("Saving the object");
		studentDAO.save(temp1student);
		// display the save student
		int theId= temp1student.getId();
		System.out.println("the id is +" +theId);

		// retrive the object based on id
		System.out.println("retrived id ");
		Student mystudent= studentDAO.findById(theId);

		// foudn the id
		System.out.println("my id is "+ mystudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
