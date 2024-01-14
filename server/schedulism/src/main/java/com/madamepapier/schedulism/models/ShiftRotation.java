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
    @JoinColumn (name = "created_by_id")
    @JsonIgnoreProperties ({"shiftRotations"})
    private User createdBy;

    @ManyToOne
    @JoinColumn (name = "user_id")
    @JsonIgnoreProperties ({"shiftRotations"})
    private User user;

    @ManyToOne
    @JoinColumn (name = "shiftType_id")
    @JsonIgnoreProperties ({"shiftRotations"})
    private ShiftType shiftType;

    @ManyToOne
    @JoinColumn (name = "requested_by_id")
    @JsonIgnoreProperties ({"requestedShifts"})
    private User requestedBy;

    @ManyToOne
    @JoinColumn (name = "approved_by_id")
    @JsonIgnoreProperties ({"approvedShifts"})
    private User approvedBy;


    public ShiftRotation(LocalDate date, User user, ShiftType shiftType) {
        this.date = date;
        this.user = user;
        this.shiftType = shiftType;
    }
    public ShiftRotation() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }
}

