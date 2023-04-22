package com.iiitb.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiitb.userservice.model.Question;
import com.iiitb.userservice.model.User;
import com.iiitb.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private final UserService userService;

    @PostMapping(path = "/add")
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

    @PostMapping(path = "/getQuestions")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Question> getQuestions(@RequestBody User user){
        List<Question> questions = userService.getQuestions(user);
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(Question q:questions){
            sb.append(" Question: ");
            sb.append(q.getQuestion());
            sb.append("\n Question id: ");
            sb.append(q.getQID());
            sb.append("\n User id: ");
            sb.append(q.getUser_id());
            sb.append("\n Answer: ");
            sb.append(q.getAnswer());
            sb.append("\n Options:  ");
            sb.append(q.getOption1());
            sb.append(" ");
            sb.append(q.getOption2());
            sb.append(" ");
            sb.append(q.getOption3());
            sb.append(" ");
            sb.append(q.getOption4());
            sb.append("\n Version:");
            sb.append(q.getVersion());
            sb.append("\n Correct Option: ");
            sb.append(q.getCorrectOption());
            sb.append("\n");
        }
        sb.append("}");
        System.out.println(sb.toString());

        return questions;
//        return sb.toString();
    }

    @GetMapping(path = "/listenToQuestions")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getQuestions(){
        return "";
    }
}


