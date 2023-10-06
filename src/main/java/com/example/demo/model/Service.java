package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Service {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nom;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
