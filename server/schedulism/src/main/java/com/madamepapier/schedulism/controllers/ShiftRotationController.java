package com.madamepapier.schedulism.controllers;

import com.madamepapier.schedulism.models.ShiftRotation;
import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.services.ShiftRotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shift-rotations")
public class ShiftRotationController {

    @Autowired
    ShiftRotationService shiftRotationService;

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
}
