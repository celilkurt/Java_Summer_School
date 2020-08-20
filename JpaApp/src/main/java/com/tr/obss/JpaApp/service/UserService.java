package com.tr.obss.JpaApp.service;


import com.tr.obss.JpaApp.dao.UserRepository;
import com.tr.obss.JpaApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //patchUser(int age)

    @Autowired
    UserRepository userRepository;

    @Value("${spring.application.name}")
    private String appName;

    @PostConstruct
    public void postContructor(){

        userRepository.save(new User(1l,"ali","email@mail.com",38));
    }

    public ResponseEntity<String> getAppName(){

        return new ResponseEntity<String>(appName, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(long id){

        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getUserByName(String name){

        Optional<List<User>> users = userRepository.findByUsername(name);

        if(!users.isPresent())
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<User>>(users.get(), HttpStatus.OK);
    }

    public ResponseEntity<User> addUser(User user){

        User responseUser = userRepository.save(user);

        if(responseUser != null)
            return new ResponseEntity<User>(responseUser, HttpStatus.OK);

        return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);

    }

    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userRepository.findAll();

        if(!users.isEmpty())
            return new ResponseEntity<List<User>>(users,HttpStatus.OK);
        return new ResponseEntity<List<User>>(HttpStatus.OK);
    }

     public ResponseEntity<Optional<List<User>>> getUserByEmailAndUsername( String email,String username){

         Optional<List<User>> users = userRepository.findByEmailAndUsername(email, username);
         if(users.isPresent())
             return new ResponseEntity<Optional<List<User>>>(users,HttpStatus.OK);
         else
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);

     }

    public ResponseEntity<String> deleteUserById(@PathVariable Long id){

        userRepository.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<User> updateUser( User user){

        User newUser = userRepository.save(user);
        if(newUser != null)
            return new ResponseEntity<User>(newUser,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<User> updateUserAge(Long id, int newAge){

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setAge(newAge);
            User responseUser = userRepository.save(user.get());
            return new ResponseEntity<User>(responseUser,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
