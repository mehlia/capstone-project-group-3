package com.madamepapier.schedulism.services;

import com.madamepapier.schedulism.components.CustomException;
import com.madamepapier.schedulism.models.ShiftRotation;
import com.madamepapier.schedulism.models.ShiftType;
import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.models.UserRole;
import com.madamepapier.schedulism.repositories.ShiftRotationRepository;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public ShiftRotation findShiftRotationById(long shiftRotationId, long requesterId){
        User requester = userRepository.findById(requesterId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        ShiftRotation shiftRotationToFind  = shiftRotationRepository.findById(shiftRotationId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (!(requester.getUserRole() == UserRole.HR_EMPLOYEE) && (requesterId != shiftRotationToFind.getCreatedBy().getId())) {
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }
        return shiftRotationToFind;
    }

//    Create new shift rotation

    public ShiftRotation createNewShiftRotation(long shiftTypeId, long createdByUserId, ShiftRotation newShiftRotation) {
        User createdBy = userRepository.findById(createdByUserId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (createdBy.getUserRole() != UserRole.HR_EMPLOYEE) {
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }

        ShiftType shiftType = shiftTypeService.findShiftTypeById(shiftTypeId);
        newShiftRotation.setCreatedBy(createdBy);
        newShiftRotation.setShiftType(shiftType);

        return shiftRotationRepository.save(newShiftRotation);
    }

//    Add user to existing shift
    public ShiftRotation addUserToShiftRotation(long shiftTypeId, long requesterId, long userId) throws Exception { // might need to be shiftRotationId
        ShiftRotation existingShiftRotation = shiftRotationRepository.findByShiftTypeIdAndUserId(shiftTypeId, userId);

        if (existingShiftRotation != null && existingShiftRotation.getRequestedBy() != null) {
            throw new CustomException("User is already on this shift.");
        }
        User userToAdd = userService.findUserById(requesterId, userId);
        ShiftType shiftTypeToAdd = existingShiftRotation.getShiftType();

        existingShiftRotation.setUser(userToAdd);
        existingShiftRotation.setShiftType(shiftTypeToAdd);

        ShiftRotation updatedShiftRotation = shiftRotationRepository.save(existingShiftRotation);

        return updatedShiftRotation;
    }

    // Request a shift
    public void requestShift(long shiftRotationId, long requesterId) {
        ShiftRotation shiftRotation = shiftRotationRepository.findById(shiftRotationId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        User requester = userRepository.findById(requesterId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        shiftRotation.setRequestedBy(requester);
        shiftRotationRepository.save(shiftRotation);
    }

    // Approve a shift request -- should make this void?
    public ShiftRotation approveShift(long shiftRotationId, long approverId) {
        ShiftRotation shiftToApprove = shiftRotationRepository.findById(shiftRotationId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        User approver = userRepository.findById(approverId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (approver.getUserRole() != UserRole.HR_EMPLOYEE) {
            throw new CustomException("Only HR employees can approve shift requests.");
        }

        shiftToApprove.setApprovedBy(approver);
        return shiftRotationRepository.save(shiftToApprove);
    }
}
