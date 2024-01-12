package com.madamepapier.schedulism.controllers;

import com.madamepapier.schedulism.models.ShiftRotation;
import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

//    GET all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    // Get user by id
    @GetMapping("/{requesterId}/find/{idToFind}")
    public ResponseEntity<Optional<User>> findUserById(
            @PathVariable long requesterId,
            @PathVariable long idToFind
    ) {
        try {
            Optional<User> foundUser = userService.findUserById(requesterId, idToFind);
            return ResponseEntity.ok(foundUser);
        } catch (ErrorResponseException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{user_id}/shift-rotations")
    public ResponseEntity<List<ShiftRotation>> findAllShiftsByUserId(@PathVariable long userId){
        try{
            List<ShiftRotation> userShifts = userService.findAllShiftsByUserId(userId);
            return new ResponseEntity<>(userShifts, HttpStatus.OK);
        }catch (ErrorResponseException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
