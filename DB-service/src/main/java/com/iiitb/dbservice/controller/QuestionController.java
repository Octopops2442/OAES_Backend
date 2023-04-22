package com.iiitb.dbservice.controller;

import com.iiitb.dbservice.model.Question;
import com.iiitb.dbservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class QuestionController{

    //    @Autowired
    private final QuestionService questionService;

    @PostMapping(path="/modify")
    @ResponseStatus(HttpStatus.CREATED)
    public String modifyQuestion(@RequestBody Question question){
        questionService.modifyQuestion(question);
        return "Modified Question successfully\n";
    }

    @PostMapping(path = "/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteQuestion(@RequestBody Question question){
        questionService.deleteQuestion(question);
        return "Question Deleted Successfully\n";
    }

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return "Question Added Successfully\n";
    }
}