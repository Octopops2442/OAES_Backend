package com.iiitb.userservice.model;

import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer user_id;
    @Column
    private String username;
    @Column
    private String password;
}
