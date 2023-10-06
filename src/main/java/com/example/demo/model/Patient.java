package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nom;
    private String prenom;
    private String email;
    private Integer telephone;
    private String adresse;
    private Date dateNaissance;
    private String lieuNaissance;
    private String matricule;
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Service service ;


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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse ) {
        this.adresse = adresse;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule ) {
        this.matricule = matricule;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance ) {
        this.lieuNaissance = lieuNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance ) {
        this.dateNaissance = dateNaissance;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
