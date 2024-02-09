package com.danillo.nlw.modules.students.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentCertificationAnswerDTO {
    private String email;
    private String technology;
    private List<QuestionAnswerDTO> questionAnswerDTO;
}
