package com.danillo.nlw.modules.students.useCases;

import com.danillo.nlw.modules.questions.entities.Question;
import com.danillo.nlw.modules.questions.repositories.QuestionRepository;
import com.danillo.nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.danillo.nlw.modules.students.dto.VerifyIfHasCertificationDTO;
import com.danillo.nlw.modules.students.entities.AnswersCertification;
import com.danillo.nlw.modules.students.entities.CertificationStudent;
import com.danillo.nlw.modules.students.entities.Student;
import com.danillo.nlw.modules.students.repositories.CertificationStudentRepository;
import com.danillo.nlw.modules.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    public CertificationStudent execute(StudentCertificationAnswerDTO dados) throws Exception{
        var hasCertification = this.verifyIfHasCertificationUseCase
                .execute(new VerifyIfHasCertificationDTO(dados.getEmail(), dados.getTechnology()));

        if(hasCertification){
            throw new Exception("Você já tirou a sua certificação.");
        }

        List<Question> questions = questionRepository.findByTechnology(dados.getTechnology());
        List<AnswersCertification> answersCertifications = new ArrayList<>();

        AtomicInteger correctAnswers = new AtomicInteger(0);

        dados.getQuestionAnswerDTO()
                .stream().forEach(questionAnswer -> {
                    var question = questions.stream()
                            .filter(q -> q.getId().equals(questionAnswer.getIdQuestion())).findFirst().get();

                    var findCorrectAlternative = question.getAlternatives().stream()
                            .filter(alternative -> alternative.isCorrect()).findFirst().get();

                    if (findCorrectAlternative.getId().equals(questionAnswer.getIdAlternative())) {
                        questionAnswer .setCorrect(true);
                        correctAnswers.incrementAndGet();
                    } else {
                        questionAnswer.setCorrect(false);
                    }

                    var answerCertification = AnswersCertification.builder()
                            .idAnswer(questionAnswer.getIdAlternative())
                            .idQuestion(questionAnswer.getIdQuestion())
                            .isCorrect(questionAnswer.isCorrect()).build();

                    answersCertifications.add(answerCertification);
        });

        var student = studentRepository.findByEmail(dados.getEmail());
        UUID idStudent;

        if(student.isEmpty()){
            var studentCreated = Student.builder().email(dados.getEmail()).build();
            studentCreated = studentRepository.save(studentCreated);
            idStudent = studentCreated.getId();
        } else {
            idStudent = student.get().getId();
        }

        CertificationStudent certificationStudent = CertificationStudent.builder()
                .technology(dados.getTechnology())
                .idStudent(idStudent)
                .grade(correctAnswers.get())
                .build();

        var certificationStudentCreated = certificationStudentRepository.save(certificationStudent);

        answersCertifications.stream().forEach(answersCertification -> {
            answersCertification.setIdCertification(certificationStudent.getId());
            answersCertification.setCertificationStudent(certificationStudent);
        });

        certificationStudent.setAnswersCertification(answersCertifications);
        certificationStudentRepository.save(certificationStudent);

        return certificationStudentCreated;
    }
}
