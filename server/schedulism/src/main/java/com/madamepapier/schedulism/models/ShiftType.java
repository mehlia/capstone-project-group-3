package com.madamepapier.schedulism.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shift_types")
public class ShiftType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private ShiftSlot shiftSlot;

    @Column
    private LocalTime startTime; // change to DateTime perhaps

    @Column
    private LocalTime endTime;

    @OneToMany (mappedBy = "shiftType")
    private List<ShiftRotation> shiftRotations;

    public ShiftType(ShiftSlot shiftSlot, LocalTime startTime, LocalTime endTime) {
        this.shiftSlot = shiftSlot;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftRotations = new ArrayList<>();
    }

    public ShiftType(){
    }

    public List<ShiftRotation> getShiftRotations() {
        return shiftRotations;
    }

    public void setShiftRotations(List<ShiftRotation> shiftRotations) {
        this.shiftRotations = shiftRotations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShiftSlot getShiftSlot() {
        return shiftSlot;
    }

    public void setShiftSlot(ShiftSlot shiftSlot) {
        this.shiftSlot = shiftSlot;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
} //Last bracket
