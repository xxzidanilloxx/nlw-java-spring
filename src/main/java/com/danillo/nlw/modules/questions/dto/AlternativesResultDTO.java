package com.danillo.nlw.modules.questions.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AlternativesResultDTO {

    private UUID id;
    private String description;
}
