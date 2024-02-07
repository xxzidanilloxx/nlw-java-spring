package com.danillo.nlw.modules.students.useCases;

import com.danillo.nlw.modules.students.dto.VerifyIfHasCertificationDTO;
import com.danillo.nlw.modules.students.entities.CertificationStudent;
import com.danillo.nlw.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;
    public boolean execute(VerifyIfHasCertificationDTO dados){

        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dados.getEmail(), dados.getTechnology());
        if(!result.isEmpty()){
            return true;
        }
        return false;
    }
}
