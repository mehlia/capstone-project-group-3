package com.madamepapier.schedulism.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "shift_rotation")
public class ShiftRotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn (name = "user_id")
    @JsonIgnoreProperties ({"shiftRotation"})
    private User user;

    @ManyToOne
    @JoinColumn (name = "shiftType_id")
    @JsonIgnoreProperties ({"shiftRotation"})
    private ShiftType shiftType;


    public ShiftRotation(LocalDate date, User user, ShiftType shiftType) {
        this.date = date;
        this.user = user;
        this.shiftType = shiftType;
    }
    public ShiftRotation() {
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

