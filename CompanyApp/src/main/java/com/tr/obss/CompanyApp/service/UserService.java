package com.tr.obss.CompanyApp.service;

import com.tr.obss.CompanyApp.dao.CompanyRepository;
import com.tr.obss.CompanyApp.dao.UserRepository;
import com.tr.obss.CompanyApp.entity.Company;
import com.tr.obss.CompanyApp.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = Logger.getLogger(CompanyService.class);


    public ResponseEntity<User> getUserById(long id){

        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            logger.error("User not found with id: " + id);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    public ResponseEntity<User> getUserByName(String name){

        Optional<User> users = userRepository.findByName(name);

        if(!users.isPresent()){
            logger.error("User not found with name: " + name);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<User>(users.get(), HttpStatus.OK);
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
            logger.error("Users not found!");
            return new ResponseEntity<List<User>>(HttpStatus.OK);
        }

    }





    public ResponseEntity<User> updateUser( User user){

        logger.info("Request to update user: " + user);

        User newUser = userRepository.save(user);
        if(newUser != null)
            return new ResponseEntity<User>(newUser,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


}
