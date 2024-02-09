package com.danillo.nlw.modules.certifications.useCases;

import com.danillo.nlw.modules.students.entities.CertificationStudent;
import com.danillo.nlw.modules.students.repositories.CertificationStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Top10RankingUseCase {

    private CertificationStudentRepository certificationStudentRepository;

    public List<CertificationStudent> execute(){
        var result = this.certificationStudentRepository.findTop10ByOrderByGradeDesc();
        return result;
    }
}
