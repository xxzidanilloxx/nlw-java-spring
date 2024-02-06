package com.danillo.nlw.modules.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CertificationStudent {
    private UUID id;
    private UUID idStudent;
    private String technology;
    private int grade;
    private List<AnswersCertification> answersCertification;
}
