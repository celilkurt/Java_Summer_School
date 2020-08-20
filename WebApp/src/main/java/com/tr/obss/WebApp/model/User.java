package com.tr.obss.WebApp.model;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User{

    private long id;
    @Size(min=2)
    private String username;
    @Email
    private String email;
    @Size
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}