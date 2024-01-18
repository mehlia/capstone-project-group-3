package com.madamepapier.schedulism.components;

import com.madamepapier.schedulism.models.*;
import com.madamepapier.schedulism.repositories.ShiftRotationRepository;
import com.madamepapier.schedulism.repositories.ShiftTypeRepository;
import com.madamepapier.schedulism.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShiftTypeRepository shiftTypeRepository;

    @Autowired
    ShiftRotationRepository shiftRotationRepository;

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

//      Employee 5
        User userFive = new User(
                "Wynn",
                "Wynn@mail.com",
                "WynnRF",
                "Stock Operator",
                UserRole.EMPLOYEE);

//        Employee 6
        User userSix = new User(
                "Kacper",
                "Kacper@mail.com",
                "KacperRF",
                "IT technician",
                UserRole.EMPLOYEE);

//        Employee 7
        User userSeven = new User(
                "Mehlia",
                "Mehlia@mail.com",
                "MehliaRF",
                "Manager",
                UserRole.HR_EMPLOYEE);

//        Employee 8
        User userEight = new User(
                "Rayster",
                "Rayster@mail.com",
                "RaysterRF",
                "Security guard",
                UserRole.EMPLOYEE);

        userRepository.save(userOne);
        userRepository.save(userTwo);
        userRepository.save(userThree);
        userRepository.save(userFour);
        userRepository.save(userFive);
        userRepository.save(userSix);
        userRepository.save(userSeven);
        userRepository.save(userEight);

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


//        Shift Rotations

//       User one shift
        ShiftRotation shiftRotationOne = new ShiftRotation(
                LocalDate.of(2023,01, 01),
                userOne,
                shiftTypeOne, true, false);

        ShiftRotation shiftRotationTwo = new ShiftRotation(
                LocalDate.of(2023,01, 02),
                userOne,
                shiftTypeThree, true, false);

        ShiftRotation shiftRotationThree = new ShiftRotation(
                LocalDate.of(2023,01, 03),
                userOne,
                shiftTypeFour, true, false);

//        User two shift
        ShiftRotation shiftRotationFour = new ShiftRotation(
                LocalDate.of(2023,01, 01),
                userTwo,
                shiftTypeOne, true, false);

        ShiftRotation shiftRotationFive = new ShiftRotation(
                LocalDate.of(2023,01, 02),
                userTwo,
                shiftTypeThree, true, false);

        ShiftRotation shiftRotationSix = new ShiftRotation(
                LocalDate.of(2023,01, 04),
                userTwo,
                shiftTypeTwo, true, false);

//        User three shift
        ShiftRotation shiftRotationSeven = new ShiftRotation(
                LocalDate.of(2023,01, 01),
                userThree,
                shiftTypeFour, true, false);

//        User four shift
        ShiftRotation shiftRotationEight = new ShiftRotation(
                LocalDate.of(2023,01, 04),
                userFour,
                shiftTypeOne, true, false);

        ShiftRotation shiftRotationNine = new ShiftRotation(
                LocalDate.of(2023,01, 05),
                userFour,
                shiftTypeOne, true, false);

        ShiftRotation shiftRotationTen = new ShiftRotation(
                LocalDate.of(2023,01, 06),
                userFour,
                shiftTypeOne, true, false);

//        User five shift
        ShiftRotation shiftRotationEleven = new ShiftRotation(
                LocalDate.of(2023,01, 01),
                userFive,
                shiftTypeFour, true, false);


//        User six shift
        ShiftRotation shiftRotationTwelve = new ShiftRotation(
                LocalDate.of(2023,01, 01),
                userSix,
                shiftTypeFive, true, false);

//        User seven shift
        ShiftRotation shiftRotationThirteen = new ShiftRotation(
                LocalDate.of(2023,01, 05),
                userSeven,
                shiftTypeTwo, true, false);

        ShiftRotation shiftRotationFourteen = new ShiftRotation(
                LocalDate.of(2023,01, 06),
                userSeven,
                shiftTypeTwo, true, false);

        ShiftRotation shiftRotationFifteen = new ShiftRotation(
                LocalDate.of(2023,01, 07),
                userSeven,
                shiftTypeFour, true, false);

//        User eight shift
        ShiftRotation shiftRotationSixteen = new ShiftRotation(
                LocalDate.of(2023,01, 01),
                userEight,
                shiftTypeThree, true, false);

        ShiftRotation shiftRotationSeventeen = new ShiftRotation(
                LocalDate.of(2023,01, 02),
                userEight,
                shiftTypeThree, true, false);

        shiftRotationRepository.save(shiftRotationOne);
        shiftRotationRepository.save(shiftRotationTwo);
        shiftRotationRepository.save(shiftRotationThree);
        shiftRotationRepository.save(shiftRotationFour);
        shiftRotationRepository.save(shiftRotationFive);
        shiftRotationRepository.save(shiftRotationSix);
        shiftRotationRepository.save(shiftRotationSeven);
        shiftRotationRepository.save(shiftRotationEight);
        shiftRotationRepository.save(shiftRotationNine);
        shiftRotationRepository.save(shiftRotationTen);
        shiftRotationRepository.save(shiftRotationEleven);
        shiftRotationRepository.save(shiftRotationTwelve);
        shiftRotationRepository.save(shiftRotationThirteen);
        shiftRotationRepository.save(shiftRotationFourteen);
        shiftRotationRepository.save(shiftRotationFifteen);
        shiftRotationRepository.save(shiftRotationSixteen);
        shiftRotationRepository.save(shiftRotationSeventeen);

    }





} //Last
