package com.tr.obss.WebApp.service;


import com.tr.obss.WebApp.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users;

    @Value("${spring.application.name}")
    private String appName;

    @PostConstruct
    public void postContructor(){
        users = new ArrayList<>();
        users.add(new User(1l,"ali","email@mai.com",38));
        users.add(new User(2l,"veli","email@mai.com",31));
        users.add(new User(3l,"kübra","email@mai.com",32));
    }

    public String getAppName(){
        return appName;
    }

    public User getUser(long id){

        for(User user: users)
            if(user.getId() == id)
                return user;

        return null;
    }

    public User addUser(User user){

        users.add(user);
        return getUser(user.getId());
    }


}
