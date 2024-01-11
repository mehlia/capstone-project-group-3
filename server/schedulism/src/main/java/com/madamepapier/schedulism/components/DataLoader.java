package com.madamepapier.schedulism.components;

import com.madamepapier.schedulism.models.ShiftSlot;
import com.madamepapier.schedulism.models.ShiftType;
import com.madamepapier.schedulism.models.User;
import com.madamepapier.schedulism.models.UserRole;
import com.madamepapier.schedulism.repositories.ShiftTypeRepository;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShiftTypeRepository shiftTypeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        //users
//        Employee 1
        User userOne = new User(
                "Annie",
                "annie@mail.com",
                "AnnieRF",
                "Admin",
                UserRole.HR_EMPLOYEE);
        userRepository.save(userOne);

//    Employee 2
    User userTwo = new User(
            "Janet",
            "janet@mail.com",
            "JanetRF",
            "Sales Assistant",
            UserRole.EMPLOYEE);
        userRepository.save(userTwo);


        //     Shift types
//        One
        ShiftType shiftTypeOne = new ShiftType(
                ShiftSlot.MORNING,
                LocalTime.of(8,00),
                LocalTime.of(14, 00)
        );
        shiftTypeRepository.save(shiftTypeOne);


    }





} //Last
