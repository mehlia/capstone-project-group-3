package com.madamepapier.schedulism.services;

import com.madamepapier.schedulism.models.ShiftType;
import com.madamepapier.schedulism.repositories.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;


@Service
public class ShiftTypeService {
   @Autowired
    ShiftTypeRepository shiftTypeRepository;

    public ShiftType findShiftTypeById(long shiftTypeId) {
        return shiftTypeRepository.findById(shiftTypeId). orElseThrow(() ->
                new ErrorResponseException(HttpStatus.NOT_FOUND));
    }

}
