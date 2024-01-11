package com.madamepapier.schedulism.models;

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


    public ShiftType(ShiftSlot shiftSlot, Time startTime, Time endTime) {
        this.shiftSlot = shiftSlot;
        this.startTime = startTime;
        this.endTime = endTime;
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
} //Last bracket
