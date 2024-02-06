package com.danillo.nlw.modules.students.controllers;

import com.danillo.nlw.modules.students.dto.VerifyIfHasCertificationDTO;
import com.danillo.nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping(value = "/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyIfHasCertificationDTO dados){
        var result = this.verifyIfHasCertificationUseCase.execute(dados);

        if(result){
            return "O usuário já realizou a prova.";
        }
        return "O usuário pode realizar a prova.";
    }
}
