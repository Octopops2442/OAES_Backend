package com.iiitb.dbservice.service;

import com.iiitb.dbservice.model.Question;
import com.iiitb.dbservice.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@RequiredArgsConstructor
public class QuestionService{

    @Autowired
    private final QuestionRepository questionRepository;
    @Autowired
    public void modifyQuestion(Question question){
        questionRepository.save(question);
    }

    @Autowired
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Autowired
    public void deleteQuestion(Question question){
        questionRepository.deleteById(question.getQID());
    }
}
