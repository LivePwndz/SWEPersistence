package edu.mum.cs.cs425.studentmgmt;

import com.sun.deploy.security.CertStore;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//{ studentId:1, studentNumber: 000-61-0001, firstName:Anna, middleName: Lynn, LastName: Smith, cgpa:3.45, dateOfEnrollment:2019/5/24 }
		Student student = new Student("000-61-0001","Anna", "Lynn", "Smith", 3.45f, LocalDate.of(2019,5,24));
		student.setTranscript( new Transcript("BS Computer Science"));
		Student savedStudent = saveStudent(student);
		System.out.println(savedStudent);
	}

	private Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
}
