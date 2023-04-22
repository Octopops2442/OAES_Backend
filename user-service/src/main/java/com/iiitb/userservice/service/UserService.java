package com.iiitb.userservice.service;

import com.iiitb.userservice.model.Question;
import com.iiitb.userservice.model.User;
import com.iiitb.userservice.repository.QuestionRepository;
import com.iiitb.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class UserService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final QuestionRepository questionRepository;
    @Autowired
    public Boolean addUser(User user){
        List<User> users = userRepository.findAll();

        for(User u: users){
            if (u.getUsername() == null) {
                userRepository.delete(u);

                continue;
            }

            System.out.println("User "+ u.getUsername() + " " + u.getPassword());
            if( user.getUsername() == u.getUsername()) return false;
        }
        System.out.println(user.getUsername());
        userRepository.save(user);
        return true;
    }

    @Autowired
    public List<Question> getQuestions(User user){
//        return userRepository.findAllQuestions(user.getUid());
        List<Question> qList = questionRepository.findAll();
        List<Question> result = new ArrayList<>();

        for (Question q: qList) {
            if (q.getUser_id() == user.getUser_id()) {
                result.add(q);
            }
        }
        return result;
    }

    public boolean login(User user) {
        List<User> users = userRepository.findAll();
        for(User u: users){
            if (u.getUsername() == null) {
                userRepository.delete(u);

                continue;
            }

            System.out.println("User "+ u.getUsername() + " " + u.getPassword());
            if( user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) return true;
        }
        return false;
    }
}
