package com.danillo.nlw.modules.questions.controllers;

import com.danillo.nlw.modules.questions.dto.AlternativesResultDTO;
import com.danillo.nlw.modules.questions.dto.QuestionResultDTO;
import com.danillo.nlw.modules.questions.entities.Alternatives;
import com.danillo.nlw.modules.questions.entities.Question;
import com.danillo.nlw.modules.questions.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
        var result = this.questionRepository.findByTechnology(technology);

        var toMap = result.stream().map(question -> mapQuestionToDTO(question))
                .collect(Collectors.toList());
        return toMap;
    }

    static QuestionResultDTO mapQuestionToDTO(Question question){
        var questionResultDTO = QuestionResultDTO.builder()
                .id(question.getId())
                .technology(question.getTechnology())
                .description(question.getDescription()).build();

        List<AlternativesResultDTO> alternativesResultDTO = question.getAlternatives()
                .stream().map(alternative -> mapAlternativeDTO(alternative))
                .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativesResultDTO);
        return questionResultDTO;
    }

    static AlternativesResultDTO mapAlternativeDTO(Alternatives alternatives) {
        return AlternativesResultDTO.builder()
                .id(alternatives.getId())
                .description(alternatives.getDescription()).build();
    }
}
