package com.tr.obss.JpaApp.service;


import com.tr.obss.JpaApp.dao.AddressRepository;
import com.tr.obss.JpaApp.dao.UserRepository;
import com.tr.obss.JpaApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Value("${spring.application.name}")
    private String appName;

    @PostConstruct
    public void postContructor(){
        System.out.println("Hello world!");
    }

    public ResponseEntity<String> getAppName(){

        return new ResponseEntity<String>(appName, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(long id){

        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            logger.error("user not found with id: " + id);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getUserByName(String name){

        Optional<List<User>> users = userRepository.findByUsername(name);

        if(!users.isPresent()){
            logger.error("users or user not found with name: " + name);
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<List<User>>(users.get(), HttpStatus.OK);
    }

    public ResponseEntity<User> addUser(User user){

        User responseUser = userRepository.save(user);

        if(responseUser != null){
            logger.info("Request to create user: " + user);
            return new ResponseEntity<User>(responseUser, HttpStatus.OK);
        }else{
            logger.error( "User not saved: " + user);
            return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userRepository.findAll();

        if(!users.isEmpty()){
            return new ResponseEntity<List<User>>(users,HttpStatus.OK);
        }else{
            logger.error("user or users not found!");
            return new ResponseEntity<List<User>>(HttpStatus.OK);
        }



    }

     public ResponseEntity<Optional<List<User>>> getUserByEmailAndUsername( String email,String username){

         Optional<List<User>> users = userRepository.findByEmailAndUsername(email, username);
         if(users.isPresent())
             return new ResponseEntity<Optional<List<User>>>(users,HttpStatus.OK);
         else{
             logger.error("User not found with username: " + username + " and email: " + email );
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }


     }

    public ResponseEntity<String> deleteUserById(@PathVariable Long id){

        logger.info("Request to delete user: " + id);
        userRepository.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<User> updateUser( User user){

        logger.info("Request to update user: " + user);

        User newUser = userRepository.save(user);
        if(newUser != null)
            return new ResponseEntity<User>(newUser,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<User> updateUserAge(Long id, int newAge){


        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            logger.info("Request to update user age: " + newAge);
            user.get().setAge(newAge);
            User responseUser = userRepository.save(user.get());
            return new ResponseEntity<User>(responseUser,HttpStatus.OK);
        }

        logger.error("Update not successful");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<User>> getUsersWithNamedQuery(String name, String email, int age){

        Optional<List<User>> users = userRepository.findByNamedQuery(name,email,age);

        if(users.isPresent()){
            return new ResponseEntity<List<User>>(users.get(),HttpStatus.OK);
        }else{
            logger.error("User not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Transactional
    public ResponseEntity<List<User>> addAllUsers(List<User> users){

        List<User> users2 = new ArrayList<>();
            for(User user:users){
                users2.add(userRepository.save(user));

            }

        return new ResponseEntity<List<User>>(users2,HttpStatus.OK);


    }

}
