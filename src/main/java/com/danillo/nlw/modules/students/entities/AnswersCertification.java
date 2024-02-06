package com.danillo.nlw.modules.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswersCertification {
    private UUID id;
    private UUID idCertification;
    private UUID idStudent;
    private UUID idQuestion;
    private UUID idAnswer;
    private boolean isCorrect;
}
