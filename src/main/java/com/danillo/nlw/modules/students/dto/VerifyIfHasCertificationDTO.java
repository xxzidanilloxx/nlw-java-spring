package com.danillo.nlw.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VerifyIfHasCertificationDTO {
    private String email;
    private String technology;
}
