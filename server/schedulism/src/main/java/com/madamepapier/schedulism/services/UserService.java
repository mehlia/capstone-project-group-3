package com.madamepapier.schedulism.services;

import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//    Display all employees function
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


}
