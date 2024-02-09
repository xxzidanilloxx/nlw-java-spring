package com.danillo.nlw.modules.students.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class QuestionAnswerDTO {
    private UUID idQuestion;
    private UUID idAlternative;
    private boolean isCorrect;
}
