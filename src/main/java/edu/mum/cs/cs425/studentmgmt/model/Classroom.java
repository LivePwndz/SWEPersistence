package edu.mum.cs.cs425.studentmgmt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity()
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    private String buildingName;
    private String roomNo;
    @OneToMany(mappedBy = "classroom")
    private List<StudentClassroom> studentClassrooms;

    public Classroom() {
    }

    public Classroom(String buildingName, String roomNo) {
        this.buildingName = buildingName;
        this.roomNo = roomNo;
    }
}
