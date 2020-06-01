package edu.mum.cs.cs425.studentmgmt.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank
    @Column( name = "student_no", nullable = false, unique = true)
    private String studentNo;

    @NotBlank
    @Column( name = "first_name", nullable = false)
    private String firstName;
    @Column( name = "middle_name", nullable = true)
    private String middleName;

    @NotBlank
    @Column( name = "last_name", nullable = false)
    private String lastName;

    @Min(value = 1)
    @Max(value = 4)
    @Column( name = "cgpa", nullable = true)
    private Float cgpa;

    @NotNull
    @Column( name = "date_of_enrollment", nullable = false)
    private LocalDate dateOfEnrollment;

    @OneToOne( cascade = CascadeType.PERSIST)
    @JoinColumn( name = "transcript_id")
    private Transcript transcript;

    public Student() {
       super();
    }

    public Student( String studentNo, String firstName, String middleName, String lastName, float cgpa, LocalDate dateOfEnrollment) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }


}
