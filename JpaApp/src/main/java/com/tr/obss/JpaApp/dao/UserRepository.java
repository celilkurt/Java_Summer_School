package com.tr.obss.JpaApp.dao;

import com.tr.obss.JpaApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<List<User>> findByUsername(String username);
    Optional<List<User>> findByEmailAndUsername(String email, String username);
    Optional<List<User>> findByNamedQuery(String name,String email,int age);

}

