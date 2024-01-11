package com.madamepapier.schedulism.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "shift_rotation")
public class ShiftRotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;
    @ManyToOne
    @JoinColumn (name = "user_id")
    @JsonIgnoreProperties ({"shiftRotation"})
    private User user;

//    @Column
//    private ShiftType shiftType;


    public ShiftRotation(Date date, User user) {
        this.date = date;
        this.user = user;
    }
    public ShiftRotation() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
