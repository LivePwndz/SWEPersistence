package edu.mum.cs.cs425.studentmgmt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity()
@Table(name = "student_classrooms")
public class StudentClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentClassroomId;
    @ManyToOne()
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    @ManyToOne()
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    public StudentClassroom() {
    }

    public StudentClassroom(Student student, Classroom classroom) {
        this.student = student;
        this.classroom = classroom;
    }
}
