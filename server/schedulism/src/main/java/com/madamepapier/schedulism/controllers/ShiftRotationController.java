package com.madamepapier.schedulism.controllers;

import com.madamepapier.schedulism.components.CustomException;
import com.madamepapier.schedulism.models.ShiftRotation;
import com.madamepapier.schedulism.models.ShiftRotationDTO;
import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.services.ShiftRotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shift-rotations")
public class ShiftRotationController {

    @Autowired
    ShiftRotationService shiftRotationService;

//    Find shift by ID
    @GetMapping("/{shiftRotationId}/users/{requesterId}")
    public ResponseEntity<ShiftRotation> findShiftById(
            @PathVariable long shiftRotationId,
            @PathVariable long requesterId){
        try {
            ShiftRotation foundShift = shiftRotationService.findShiftRotationById(shiftRotationId, requesterId);
            return new ResponseEntity<>(foundShift, HttpStatus.OK);
        } catch (ErrorResponseException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

//     Create a new shift rotation
    @PostMapping("/createShift/{requesterId}")
    public ResponseEntity <ShiftRotation> createNewShiftRotation(
            @PathVariable long requesterId,
            @RequestBody ShiftRotationDTO shiftRotationDTO){
        try{
            ShiftRotation newShift = shiftRotationService.createNewShiftRotation(shiftRotationDTO, requesterId);
            return new ResponseEntity<>(newShift, HttpStatus.CREATED);
        } catch (ErrorResponseException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


    //    Add user to existing shift
    @PostMapping("/addUserToShift")
    public ResponseEntity<ShiftRotation> addUserToShiftRotation(
            @RequestParam long shiftRotationId,
            @RequestParam long hrEmployeeId,
            @RequestParam long userToAddId){
        try {
            ShiftRotation updatedShiftRotation = shiftRotationService.addUserToShiftRotation(shiftRotationId, hrEmployeeId, userToAddId);
            return new ResponseEntity<>(updatedShiftRotation, HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // HR approve shift
    @PostMapping("/{shiftRotationId}/approve/{userId}")
    public ResponseEntity<ShiftRotation> approveShift(
            @PathVariable long shiftRotationId,
            @PathVariable long userId) {
        try {
            ShiftRotation approvedShift = shiftRotationService.approveShift(shiftRotationId, userId);
            return new ResponseEntity<>(approvedShift, HttpStatus.OK);
        } catch (ErrorResponseException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    // Request a shift
    @PostMapping("/{shiftRotationId}/request/{requesterId}")
    public ResponseEntity<Void> requestShift(
            @PathVariable long shiftRotationId,
            @PathVariable long requesterId) {
        try {
            shiftRotationService.requestShift(shiftRotationId, requesterId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ErrorResponseException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


}
