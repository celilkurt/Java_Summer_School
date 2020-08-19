package com.tr.obss.JpaApp.entity;


import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="contents")
public class Content {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @Column(name="exp_date")
    private String expDate;

    public Content(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}
