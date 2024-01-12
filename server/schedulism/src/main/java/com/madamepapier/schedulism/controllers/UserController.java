package com.madamepapier.schedulism.controllers;

import com.madamepapier.schedulism.models.ShiftRotation;
import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

//    GET all users
    @GetMapping("/{requesterId}")
    public ResponseEntity<List<User>> getAllUsers(@PathVariable long requesterId) {
        return new ResponseEntity<>(userService.findAllUsers(requesterId), HttpStatus.OK);
    }

    // Get user by id
    @GetMapping("/{requesterId}/find/{idToFind}")
    public ResponseEntity<User> findUserById(
            @PathVariable long requesterId,
            @PathVariable long idToFind
    ) {
        try {
            User foundUser = userService.findUserById(requesterId, idToFind);
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } catch (ErrorResponseException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    //Get all shift by user's id
    @GetMapping("/{userId}/shift-rotations")
    public ResponseEntity<List<ShiftRotation>> findAllShiftsByUserId(@PathVariable long userId){
        try{
            List<ShiftRotation> userShifts = userService.findAllShiftsByUserId(userId);
            return new ResponseEntity<>(userShifts, HttpStatus.OK);
        } catch (ErrorResponseException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    // Create new user
    @PostMapping("/{requesterId}")
    public ResponseEntity<User> createANewUser(
            @PathVariable long requesterId,
            @RequestBody User newUser) {
        try {
            User createdUser = userService.createNewUser(newUser, requesterId);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (ErrorResponseException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{requesterId}/{userId}")
    public ResponseEntity<User> deleteUserById(
            @PathVariable long requesterId,
            @PathVariable long userId
    ){
        try {
            return new ResponseEntity<>(userService.deleteUser(userId, requesterId), HttpStatus.NO_CONTENT);
        } catch (ErrorResponseException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
