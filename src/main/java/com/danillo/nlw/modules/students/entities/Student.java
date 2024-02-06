package com.danillo.nlw.modules.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private UUID id;
    private String email;
    private List<CertificationStudent> certificationStudent;
}
