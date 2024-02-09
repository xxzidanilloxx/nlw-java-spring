package com.danillo.nlw.modules.students.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "answers_certification_students")
public class AnswersCertification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "id_certification")
    private UUID idCertification;

    @ManyToOne
    @JoinColumn(name = "certification_student_id", insertable = false, updatable = false)
    @JsonBackReference
    private CertificationStudent certificationStudent;

    @Column(name = "id_student")
    private UUID idStudent;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column(name = "id_question")
    private UUID idQuestion;

    @Column(name = "id_answer")
    private UUID idAnswer;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
