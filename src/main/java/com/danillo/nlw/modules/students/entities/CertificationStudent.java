package com.danillo.nlw.modules.students.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity(name = "certifications")
public class CertificationStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "id_student")
    private UUID idStudent;

    @ManyToOne
    @JoinColumn(name = "id_student", insertable = false, updatable = false)
    private Student student;

    private String technology;
    private int grade;

    @OneToMany
    @JoinColumn(name = "id_answer_certification", insertable = false, updatable = false)
    @JsonBackReference
    private List<AnswersCertification> answersCertification;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
