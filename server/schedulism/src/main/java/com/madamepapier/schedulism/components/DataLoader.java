package com.madamepapier.schedulism.components;

import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.models.UserRole;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{
//
        User userOne = new User(
                "Annie",
                "annie@mail.com",
                "AnnieRF",
                "Admin",
                UserRole.HR_EMPLOYEE,
                1000);
        userRepository.save(userOne);
    }

} //Last
