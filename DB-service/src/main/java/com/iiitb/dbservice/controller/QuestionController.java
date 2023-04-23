package com.iiitb.dbservice.controller;

import com.iiitb.dbservice.model.Question;
import com.iiitb.dbservice.model.User;
import com.iiitb.dbservice.service.QuestionService;
import com.iiitb.dbservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping
public class QuestionController{

    @Autowired
    private final QuestionService questionService;
    @Autowired
    private final UserService userService;

    @PostMapping(path="/modifyQuestion")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean modifyQuestion(@RequestBody Question question){
        return questionService.modifyQuestion(question);
    }

    @PostMapping(path="/getUserId")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer getUserId(@RequestBody String username){
        Integer ret =userService.getUserId(username);
        System.out.println("user ID ="+ret);
        return ret;
    }

    @PostMapping(path = "/deleteQuestion")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean deleteQuestion(@RequestBody Question question){
        return questionService.deleteQuestion(question);
    }

    @PostMapping(path="/deleteByQId")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean deleteById(@RequestBody Integer qid){
        return questionService.deleteQuestionById(qid);

    }
    @PostMapping(path = "/addQuestion")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean addQuestion(@RequestBody Question question){
        Boolean ret = questionService.addQuestion(question);
        System.out.println("question RECIEVED :"+ question.getQuestion()+ " by "+ question.getUser_id());
        return ret;
    }



    @PostMapping(path = "/addUser")
    @ResponseBody
    public Boolean addUser(@RequestBody User user){
//        System.out.println("info "+ user);
//        return "checked successfully";
        return userService.addUser(user);
    }

    @PostMapping (path = "/login" )
    @ResponseBody
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean login(@RequestBody User user){
        System.out.println("User |"+ user.getUsername() + "| |" + user.getPassword());
        System.out.println("Ret "+ userService.login(user));
        if (userService.login(user)) return true;
        return false;
//        if(userService.login(user))return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//        return userService.login(user);
//        if (userService.login(user)) return true;
//        return false;
    }

    @PostMapping(path = "/getQuestionsByUser")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Question> getQuestions(@RequestBody User user){
        List<Question> questions = userService.getQuestions(user);
        return questions;
    }


    @GetMapping(path = "/getAllQuestions")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Question> getAllQuestions(){
        List<Question> questions = questionService.getAllQuestions();
        return questions;
    }
}