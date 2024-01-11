package com.madamepapier.schedulism.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String username;

//    @Column
//    private String password;

    @Column
    private String occupation;

//    This needs to be an ENUM
    @Enumerated(EnumType.STRING)
    @Column
    private UserRole userRole;

    @OneToMany (mappedBy = "user")
    private List<ShiftRotation> shiftRotations;



    //Constructor
    public User(String name, String email, String username, String occupation, UserRole userRole) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.occupation = occupation;
        this.userRole = userRole;
        this.shiftRotations = new ArrayList<>();
    }

    //Empty constructor
    public User() {
    }

//    Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<ShiftRotation> getShiftRotations() {
        return shiftRotations;
    }

    public void setShiftRotations(List<ShiftRotation> shiftRotations) {
        this.shiftRotations = shiftRotations;
    }
} //Last
