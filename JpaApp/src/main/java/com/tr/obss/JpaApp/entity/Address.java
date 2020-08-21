package com.tr.obss.JpaApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String details;
    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private User user;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", user=" + user +
                '}';
    }
}
