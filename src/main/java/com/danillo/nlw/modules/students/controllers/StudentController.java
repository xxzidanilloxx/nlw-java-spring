package com.danillo.nlw.modules.students.controllers;

import com.danillo.nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.danillo.nlw.modules.students.dto.VerifyIfHasCertificationDTO;
import com.danillo.nlw.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.danillo.nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    @PostMapping(value = "/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyIfHasCertificationDTO dados){
        var result = this.verifyIfHasCertificationUseCase.execute(dados);

        if(result){
            return "O usuário já realizou a prova.";
        }
        return "O usuário pode realizar a prova.";
    }

    @PostMapping(value = "/certification/answer")
    public ResponseEntity<Object> certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO){
        try{
            var result = studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
