package com.example.employe.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nom;
    private String email;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private String phone;
    @CreatedDate
    private Date dateCreat;
    private Boolean status;

    public Employe() {
        this.status = true;
    }

    public Integer  getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(Date dateCreat) {
        this.dateCreat = dateCreat;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
