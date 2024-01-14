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
    @JsonIgnoreProperties ({"shiftRotations"})
    private User user;

    @ManyToOne
    @JoinColumn (name = "shiftType_id")
    @JsonIgnoreProperties ({"shiftRotations"})
    private ShiftType shiftType;

    @Column
    private boolean isHREmployee;

    @ManyToOne
    @JoinColumn (name = "requested_by_id")
    @JsonIgnoreProperties ({"requestedShifts"})
    private User requestedBy;

    @ManyToOne
    @JoinColumn (name = "approved_by_id")
    @JsonIgnoreProperties ({"approvedShifts"})
    private User approvedBy;


    public ShiftRotation(LocalDate date, User user, ShiftType shiftType, boolean isHREmployee) {
        this.date = date;
        this.user = user;
        this.shiftType = shiftType;
        this.isHREmployee = isHREmployee;
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

    public boolean isHREmployee() {
        return isHREmployee;
    }

    public void setHREmployee(boolean HREmployee) {
        isHREmployee = HREmployee;
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
    public void requestShift(User user) {
        this.requestedBy = user;
    }

    public void approveShift(User user) {
        if (this.isHREmployee) {
            this.approvedBy = user;
        } else {
            throw new RuntimeException("Only HR employees can approve shift requests.");
        }
    }

    public void rejectShift() {
        this.requestedBy = null;
    }
}

