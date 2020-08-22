package com.tr.obss.CompanyApp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Company company;



}
