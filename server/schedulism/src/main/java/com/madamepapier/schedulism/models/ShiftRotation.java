package com.madamepapier.schedulism.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "shift_rotation")
public class ShiftRotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shift_rotation_id;

    @Column
    private long shift_type_id;
    @Column
    private long user_id;

    @Column
    private Date date;

    @ManyToOne
    @JoinTable(name = "shift_type_id")
    @JsonIgnoreProperties ({"shift_rotation"})
    private ShiftType shiftType;


    public ShiftRotation(long shift_type_id, long user_id, Date date, ShiftType shiftType) {
        this.shift_type_id = shift_type_id;
        this.user_id = user_id;
        this.date = date;
        this.shiftType = shiftType;
    }

    public ShiftRotation() {
    }

    public long getShift_type_id() {
        return shift_type_id;
    }

    public void setShift_type_id(long shift_type_id) {
        this.shift_type_id = shift_type_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public long getShift_rotation_id() {
        return shift_rotation_id;
    }

    public void setShift_rotation_id(long shift_rotation_id) {
        this.shift_rotation_id = shift_rotation_id;
    }
}
