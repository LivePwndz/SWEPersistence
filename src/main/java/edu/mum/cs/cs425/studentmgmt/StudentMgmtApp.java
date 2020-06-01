package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.StudentClassroom;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

	private final StudentRepository studentRepository;
	private final ClassroomRepository classroomRepository;
	private final StudentClassroomRepository studentClassroomRepository;

	public StudentMgmtApp(StudentRepository studentRepository, ClassroomRepository classroomRepository, StudentClassroomRepository studentClassroomRepository) {
		this.studentRepository = studentRepository;
		this.classroomRepository = classroomRepository;
		this.studentClassroomRepository = studentClassroomRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) {
		List<Classroom> classrooms = addNewClassrooms();
		Student student = new Student("000-61-0001","Anna", "Lynn", "Smith", 3.45f, LocalDate.of(2019,5,24));
		student.setTranscript( new Transcript("BS Computer Science"));
		Student savedStudent = saveStudent(student);
		addNewStudentClassrooms(student, classrooms);
		System.out.println(savedStudent);
	}

	private void addNewStudentClassrooms(Student student, List<Classroom> classrooms) {
		List<StudentClassroom> studentClassrooms = classrooms.stream().map(classroom-> new StudentClassroom(student, classroom)).collect(Collectors.toList());
		studentClassroomRepository.saveAll(studentClassrooms);
	}

	private List<Classroom> addNewClassrooms() {
		List<Classroom> classrooms = new ArrayList<>();
		classrooms.add(new Classroom("McLaughlin","RM 123"));
		classrooms.add(new Classroom("Veril Hall","RM 323"));
		return classrooms.stream().map(classroomRepository::save).collect(Collectors.toList());
	}

	private Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
}
