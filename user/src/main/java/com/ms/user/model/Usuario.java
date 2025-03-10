package com.ms.user.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userID;
    private String name;
    private String email;

    public Usuario() {
    }



    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
