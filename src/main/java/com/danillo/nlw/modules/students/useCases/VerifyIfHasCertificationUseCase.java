package com.danillo.nlw.modules.students.useCases;

import com.danillo.nlw.modules.students.dto.VerifyIfHasCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {
    public boolean execute(VerifyIfHasCertificationDTO dados){
        if(dados.getEmail().equals("teste@gmail.com") && dados.getTechnology().equals("Java")){
            return true;
        }
        return false;
    }
}
