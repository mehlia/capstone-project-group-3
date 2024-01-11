package com.madamepapier.schedulism.services;

import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.models.UserRole;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//    Display all employees function
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById(long requesterId, long idToFind) {
        User requester = userRepository.findById(requesterId).get();
        if (requester == null){
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        } else {
            if (userRepository.findById(requesterId) == userRepository.findById(idToFind)
                    || requester.getUserRole()== UserRole.HR_EMPLOYEE) {
                return userRepository.findById(idToFind);
            } else {
                throw new ErrorResponseException(HttpStatus.UNAUTHORIZED);
            }
        }
    }

}
