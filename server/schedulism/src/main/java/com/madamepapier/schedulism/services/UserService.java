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
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

//    public Optional<User> findUserById(long requesterId, long idToFind) {
//        User requester = userRepository.findById(requesterId).get();
//        if (requester == null) {
//            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
//        } else {
//            if ((requesterId) == (idToFind)) {
//                return userRepository.findById(idToFind);
//            }
//            if (requester.getUserRole() == UserRole.HR_EMPLOYEE) {
//                return userRepository.findById(idToFind);
//            } else {
//                throw new ErrorResponseException(HttpStatus.UNAUTHORIZED);
//            }
//        }
//    }
    //
    public User findUserById(long requesterId, long idToFind){
        User requester = userRepository.findById(requesterId).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));
        User userToFind = userRepository.findById(idToFind).orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));

        if(!(requester.getUserRole() == UserRole.HR_EMPLOYEE || requesterId == idToFind)){
            throw new ErrorResponseException(HttpStatus.UNAUTHORIZED);
        }
        return userToFind;
    }

//    public List<ShiftRotation> findAllShiftsByUserId(long id){
//        List<ShiftRotation> userShifts = new ArrayList<>();
//        for (long x = 0; x<shiftRotationRepository.findAll().size();) {
//            ShiftRotation shiftTemp = shiftRotationRepository.findById(x).get();
//            if (shiftTemp.getUser() == userRepository.findById(id).get()) {
//                userShifts.add(shiftTemp);
//            }
//        }
//        return userShifts;
//    }
    public List<ShiftRotation> findAllShiftsByUserId(long id) {
        List<ShiftRotation> userShifts = new ArrayList<>();
        for (ShiftRotation shiftTemp : shiftRotationRepository.findAll()) {
            if (shiftTemp.getUser() == userRepository.findById(id).get()) {
                userShifts.add(shiftTemp);
            }
        }
        return userShifts;
    }
}
