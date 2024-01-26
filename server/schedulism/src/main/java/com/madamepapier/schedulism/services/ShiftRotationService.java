package com.madamepapier.schedulism.services;

import com.madamepapier.schedulism.components.CustomException;
import com.madamepapier.schedulism.models.*;
import com.madamepapier.schedulism.repositories.ShiftRotationRepository;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShiftRotationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ShiftRotationRepository shiftRotationRepository;

    @Autowired
    ShiftTypeService shiftTypeService;

    @Autowired
    UserService userService;


//   Find shift rotation by ID
    public ShiftRotation findShiftRotationById(long shiftRotationId){

        return shiftRotationRepository.findById(shiftRotationId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
    }

//    Create new shift rotation
    public ShiftRotation createNewShiftRotation(ShiftRotationDTO shiftRotationDTO, long createdByUserId) {
        User createdBy = userRepository.findById(createdByUserId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (createdBy.getUserRole() != UserRole.HR_EMPLOYEE) {
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }

        ShiftRotation newShiftRotation = new ShiftRotation();
        newShiftRotation.setDate(shiftRotationDTO.getDate());
        newShiftRotation.setShiftType(shiftRotationDTO.getShiftType());
        newShiftRotation.setCreatedBy(createdBy);

        return shiftRotationRepository.save(newShiftRotation);
    }


    //    Add user to existing shift
    public ShiftRotation addUserToShiftRotation(long shiftRotationId, long hrEmployeeId, long userId) throws Exception {
        ShiftRotation existingShiftRotation = shiftRotationRepository.findById(shiftRotationId)
                .orElseThrow(() -> new CustomException("Shift Rotation not found."));

        // Check if user is already assigned to the shift
        if (existingShiftRotation != null && existingShiftRotation.getUser() != null && existingShiftRotation.getUser().getId() == userId) {
            throw new CustomException("User is already on this shift.");
        }

        // Check if user is already assigned to any other shift at the same time
        List<ShiftRotation> userShifts = shiftRotationRepository.findAllByUserIdAndDate(userId, existingShiftRotation.getDate());
        if (!userShifts.isEmpty()) {
            throw new CustomException("User is already assigned to a shift at this time.");
        }

        User hrEmployee = userRepository.findById(hrEmployeeId)
                .orElseThrow(() -> new CustomException("HR Employee not found"));
        if (hrEmployee.getUserRole() != UserRole.HR_EMPLOYEE) {
            throw new CustomException("Only HR employees can add users to shifts.");
        }
        User userToAdd = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException("User not found"));;

        existingShiftRotation.setUser(userToAdd);

        return shiftRotationRepository.save(existingShiftRotation);
    }

    // Request a shift
    public void requestShift(long shiftRotationId, long requesterId) {
        ShiftRotation shiftRotation = shiftRotationRepository.findById(shiftRotationId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        User requester = userRepository.findById(requesterId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        shiftRotation.setUser(requester);
        shiftRotation.setHasBeenRequested(true);
        shiftRotationRepository.save(shiftRotation);
    }

    // Approve a shift request
    public void approveShift(long shiftRotationId, long hrEmployeeId) {
        ShiftRotation shiftToApprove = shiftRotationRepository.findById(shiftRotationId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        User hrEmployee = userRepository.findById(hrEmployeeId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (hrEmployee.getUserRole() != UserRole.HR_EMPLOYEE) {
            throw new CustomException("Only HR employees can approve shift requests.");
        }

        shiftToApprove.setApproved(true);
        shiftToApprove.setHasBeenRequested(false);
        shiftRotationRepository.save(shiftToApprove);
    }

    // View all shift requests (only HR)
    public List<ShiftRotation> viewAllShiftRequests(long hrEmployeeId){
        User hrEmployee = userRepository.findById(hrEmployeeId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (hrEmployee.getUserRole() != UserRole.HR_EMPLOYEE) {
            throw new CustomException("Only HR employees can view shift requests.");
        }
        return shiftRotationRepository.findAllByHasBeenRequestedTrue();
    }
}

