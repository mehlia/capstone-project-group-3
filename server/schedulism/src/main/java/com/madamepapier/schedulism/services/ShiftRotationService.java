package com.madamepapier.schedulism.services;

import com.madamepapier.schedulism.models.ShiftRotation;
import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.models.UserRole;
import com.madamepapier.schedulism.repositories.ShiftRotationRepository;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.Optional;

@Service
public class ShiftRotationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ShiftRotationRepository shiftRotationRepository;

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
}
