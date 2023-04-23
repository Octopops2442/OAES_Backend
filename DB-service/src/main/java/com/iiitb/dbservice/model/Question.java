package com.iiitb.dbservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int QID;
    @Column
    private String Question;
    @Column
    private  String questionType;
    @Column
    private int version;
    @Column
    private String option1;
    @Column
    private String option2;
    @Column
    private String option3;
    @Column
    private String option4;
    @Column
    private int correctOption;
    @Column
    private String answer;
    @Column
    private Integer user_id;
}