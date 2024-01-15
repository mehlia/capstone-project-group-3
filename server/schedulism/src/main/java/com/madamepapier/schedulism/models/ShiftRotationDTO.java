package com.madamepapier.schedulism.models;

import java.time.LocalDate;

public class ShiftRotationDTO {

    private LocalDate date;
    private ShiftType shiftType;

    public ShiftRotationDTO(LocalDate date, ShiftType shiftType) {
        this.date = date;
        this.shiftType = shiftType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }
}
