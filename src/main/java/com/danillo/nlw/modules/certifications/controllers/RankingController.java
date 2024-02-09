package com.danillo.nlw.modules.certifications.controllers;

import com.danillo.nlw.modules.certifications.useCases.Top10RankingUseCase;
import com.danillo.nlw.modules.students.entities.CertificationStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ranking")
public class RankingController {

    @Autowired
    private Top10RankingUseCase top10RankingUseCase;

    @GetMapping(value = "/top10")
    public List<CertificationStudent> top10(){
        return this.top10RankingUseCase.execute();
    }
}
