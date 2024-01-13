package com.madamepapier.schedulism.controllers;

import com.madamepapier.schedulism.models.ShiftRotation;
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
    @PostMapping("/{requesterId}/{shiftTypeId}")
    public ResponseEntity <ShiftRotation> createNewShiftRotation(
            @PathVariable long requesterId,
            @PathVariable long shiftTypeId,
            @RequestBody ShiftRotation newShiftRotation){
        try{
            ShiftRotation shift = shiftRotationService.createNewShiftRotation(shiftTypeId, requesterId, newShiftRotation);
            return new ResponseEntity<>(shift, HttpStatus.CREATED);
            } catch (ErrorResponseException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

//    Add user to existing shift
    @PostMapping("/{shiftRotationId}/add/{userId}")
    public ResponseEntity<ShiftRotation> addUserToShiftRotation(
            @PathVariable long shiftRotationId,
            @PathVariable long userId,
            @RequestBody long requesterId){
        try {
            ShiftRotation updatedShiftRotation = shiftRotationService.addUserToShiftRotation(shiftRotationId, requesterId, userId);
            return new ResponseEntity<>(updatedShiftRotation, HttpStatus.OK);
        } catch (ErrorResponseException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
