package com.madamepapier.schedulism.services;

import com.madamepapier.schedulism.components.CustomException;
import com.madamepapier.schedulism.models.ShiftRotation;
import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.models.UserDTO;
import com.madamepapier.schedulism.models.UserRole;
import com.madamepapier.schedulism.repositories.ShiftRotationRepository;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ShiftRotationRepository shiftRotationRepository;

    //    Display all employees function
    public List<User> findAllUsers(long requesterId) {
        User requester = userRepository.findById(requesterId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));
        if (!(requester.getUserRole() == UserRole.HR_EMPLOYEE)) {
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }
        return userRepository.findAll();
    }

    //Find User by ID
    public User findUserById(long requesterId, long idToFind) {
        User requester = userRepository.findById(requesterId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));
        User userToFind = userRepository.findById(idToFind).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (!(requester.getUserRole() == UserRole.HR_EMPLOYEE || requesterId == idToFind)) {
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }
        return userToFind;
    }

    //Find all User's shifts by user ID
    public List<ShiftRotation> findAllShiftsByUserId(long id) {
        List<ShiftRotation> userShifts = new ArrayList<>();
        for (ShiftRotation shiftTemp : shiftRotationRepository.findAll()) {
            if (shiftTemp.getUser() == userRepository.findById(id).get()) {
                userShifts.add(shiftTemp);
            }
        }
        return userShifts;
    }

    // Create new user
    public User createNewUser(User newUser, long requesterId) {
        User requester = userRepository.findById(requesterId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (!(requester.getUserRole() == UserRole.HR_EMPLOYEE)) {
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }
        return userRepository.save(newUser);
    }

    // Delete a user
    public User deleteUser(long userId, long requesterId) {
        User requester = userRepository.findById(requesterId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (!(requester.getUserRole() == UserRole.HR_EMPLOYEE)) {
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }
        User userToDelete = userRepository.findById(userId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));
        {
            userToDelete.getShiftRotations().forEach(shiftRotation -> {
                shiftRotation.setUser(null);
            });
            userRepository.deleteById(userId);
        }
        return null;
    }

     // Update a User's detail
    public User updateUserDetails(long userId, UserDTO userDTO) {
        User userDetailsUpdated = userRepository.findById(userId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));

    boolean isUpdateRequired = false;

        if (!userDetailsUpdated.getName().equals(userDTO.getName())) {
            userDetailsUpdated.setName(userDTO.getName());
            isUpdateRequired = true;
        }
        if (!userDetailsUpdated.getEmail().equals(userDTO.getEmail())) {
            userDetailsUpdated.setEmail(userDTO.getEmail());
            isUpdateRequired = true;
        }
        if (!userDetailsUpdated.getOccupation().equals(userDTO.getOccupation())) {
            userDetailsUpdated.setOccupation(userDTO.getOccupation());
            isUpdateRequired = true;
        }
        if(isUpdateRequired) {
            userRepository.save(userDetailsUpdated);
        } else{
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);

        }
        return userDetailsUpdated;
    }

    //    Delete employee shifts
    public void deleteSpecificShifts (long requesterId,long userId, long shiftId){
        User requester = userRepository.findById(requesterId)
                .orElseThrow(()-> new ErrorResponseException(HttpStatus.FORBIDDEN));

        if (requester.getUserRole() != UserRole.HR_EMPLOYEE) {
            throw new CustomException("Only HR employees can delete shifts.");
        }

        User userToDeleteShift = userRepository.findById(userId)
                .orElseThrow(()-> new ErrorResponseException(HttpStatus.NOT_FOUND));

        List<ShiftRotation> shiftRotations = userToDeleteShift.getShiftRotations();

        ShiftRotation shiftRotationToRemove = null;

        for(ShiftRotation shiftRotation: shiftRotations){
            if(shiftRotation.getId().equals(shiftId)){
                shiftRotationToRemove = shiftRotation;
                break;
            }
        }
        if (shiftRotationToRemove != null){
            shiftRotationRepository.deleteById(shiftRotationToRemove.getId());
            shiftRotations.remove(shiftRotationToRemove);
            userToDeleteShift.setShiftRotations(shiftRotations);
            userRepository.save(userToDeleteShift);
        }
    }

        //Check if user is HR employee -- can implement this if/when we want to reduce code repetition
        private void checkIfUserIsHREmployee (User user){
            if (user.getUserRole() != UserRole.HR_EMPLOYEE) {
                throw new ErrorResponseException(HttpStatus.FORBIDDEN);
            }
        }
    }

