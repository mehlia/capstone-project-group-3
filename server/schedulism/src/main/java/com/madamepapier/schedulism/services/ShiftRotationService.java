package com.madamepapier.schedulism.services;

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
        User requester = userRepository.findById(requesterId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));
        ShiftRotation shiftRotationToFind  = shiftRotationRepository.findById(shiftRotationId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));
        if (!(requester.getUserRole() == UserRole.HR_EMPLOYEE) && (requesterId != shiftRotationToFind.getUser().getId())){
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }
        return shiftRotationToFind;
    }

//    Create new shift rotation
    public ShiftRotation createNewShiftRotation(long shiftTypeId, long requesterId, ShiftRotation newShiftRotation) {
        User requester = userRepository.findById(requesterId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (!(requester.getUserRole() == UserRole.HR_EMPLOYEE)) {
            throw new ErrorResponseException(HttpStatus.FORBIDDEN);
        }
        ShiftType shiftType = shiftTypeService.findShiftTypeById(shiftTypeId);
        newShiftRotation.setUser(requester);
        newShiftRotation.setShiftType(shiftType);
        return shiftRotationRepository.save(newShiftRotation);
    }

//    Add user to existing shift
    public ShiftRotation addUserToShiftRotation(long shiftTypeId, long requesterId, long userId) throws Exception{
        ShiftRotation existingShiftRotation = shiftRotationRepository.findByShiftTypeIdAndUserId(shiftTypeId, userId);

        if (existingShiftRotation.getUser() != null){
            throw new Exception("User already booked onto this shift.");
        }
        User userToAdd = userService.findUserById(requesterId, userId);
        ShiftType shiftTypeToAdd = shiftTypeService.findShiftTypeById(shiftTypeId);

//        shiftRotationRepository.save(newShiftRotation);
//        ShiftRotation updatedShiftRotation = new ShiftRotation(
//                newShiftRotation.getDate(),
//                newShiftRotation.getUser(),
//                newShiftRotation.getShiftType()
//        );
        existingShiftRotation.setUser(userToAdd);
        existingShiftRotation.setShiftType(shiftTypeToAdd);

        ShiftRotation updatedShiftRotation = shiftRotationRepository.save(existingShiftRotation);

        return updatedShiftRotation;
    }
}
