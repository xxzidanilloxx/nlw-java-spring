package com.danillo.nlw.modules.questions.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class QuestionResultDTO {
    private UUID id;
    private String technology;
    private String description;
    private List<AlternativesResultDTO> alternatives;
}
