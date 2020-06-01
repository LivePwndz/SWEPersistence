package edu.mum.cs.cs425.studentmgmt.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "transcripts")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transcript_id")
    private Long transacriptId;

    @NotBlank
    @Column(name = "degree_title", nullable = false)
    private String degreeTitle;

    @OneToOne( mappedBy = "transcript")
    private Student student;

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }
}
