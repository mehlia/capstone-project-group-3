package com.madamepapier.schedulism.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "shift_type")
public class ShiftType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shift_type_id;

    @Column
    private ShiftSlot shiftSlot;

    @Column
    private Time startTime; // change to DateTime perhaps

    @Column
    private Time endTime;

    @OneToMany (mappedBy = "shift_type")
    @JsonIgnoreProperties
    private ShiftRotation shiftRotation;

    public ShiftType(ShiftSlot shiftSlot, Time startTime, Time endTime, ShiftRotation shiftRotation) {
        this.shiftSlot = shiftSlot;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftRotation = shiftRotation;
    }

    public ShiftType(){
    }

    public ShiftSlot getShiftSlot() {
        return shiftSlot;
    }

    public void setShiftSlot(ShiftSlot shiftSlot) {
        this.shiftSlot = shiftSlot;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public ShiftRotation getShiftRotation() {
        return shiftRotation;
    }

    public void setShiftRotation(ShiftRotation shiftRotation) {
        this.shiftRotation = shiftRotation;
    }
} //Last bracket
