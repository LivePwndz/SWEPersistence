package edu.mum.cs.cs425.studentmgmt.repository;

import edu.mum.cs.cs425.studentmgmt.model.StudentClassroom;
import org.springframework.data.repository.CrudRepository;

public interface StudentClassroomRepository extends CrudRepository<StudentClassroom, Long> {
}
