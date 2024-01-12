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
//    Employee 2
    User userTwo = new User(
            "Janet",
            "janet@mail.com",
            "JanetRF",
            "Sales Assistant",
            UserRole.EMPLOYEE);

//    Employee 3
        User userThree = new User(
                "Anita",
                "anita@mail.com",
                "AnitaRF",
                "Delivery Driver",
                UserRole.EMPLOYEE);

//      Employee 4
        User userFour = new User(
                "Maxx",
                "Maxx@mail.com",
                "MaxxRF",
                "Manager",
                UserRole.HR_EMPLOYEE);

//      Employee 4
        User userFive = new User(
                "Wynn",
                "Wynn@mail.com",
                "WynnRF",
                "Stock Operator",
                UserRole.EMPLOYEE);

        userRepository.save(userOne);
        userRepository.save(userTwo);
        userRepository.save(userThree);
        userRepository.save(userFour);
        userRepository.save(userFive);

        //     Shift types
//        One
        ShiftType shiftTypeOne = new ShiftType(
                ShiftSlot.MORNING,
                LocalTime.of(8,00),
                LocalTime.of(14, 00)
        );

        //        Two
        ShiftType shiftTypeTwo = new ShiftType(
                ShiftSlot.AFTERNOON,
                LocalTime.of(12,00),
                LocalTime.of(18, 00)
        );

        //        Three
        ShiftType shiftTypeThree = new ShiftType(
                ShiftSlot.EVENING,
                LocalTime.of(16,00),
                LocalTime.of(22, 00)
        );

        //        Four
        ShiftType shiftTypeFour = new ShiftType(
                ShiftSlot.ANNUAL_LEAVE,
                LocalTime.of(00,00),
                LocalTime.of(00, 00)
        );

        //        Five
        ShiftType shiftTypeFive = new ShiftType(
                ShiftSlot.SICK_LEAVE,
                LocalTime.of(00,00),
                LocalTime.of(00, 00)
        );


        shiftTypeRepository.save(shiftTypeOne);
        shiftTypeRepository.save(shiftTypeTwo);
        shiftTypeRepository.save(shiftTypeThree);
        shiftTypeRepository.save(shiftTypeFour);
        shiftTypeRepository.save(shiftTypeFive);


    }





} //Last
