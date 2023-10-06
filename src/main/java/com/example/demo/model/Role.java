package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name ) {
        this.name = name;
    }
}
