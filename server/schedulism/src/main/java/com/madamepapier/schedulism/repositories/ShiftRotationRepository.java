package com.madamepapier.schedulism.repositories;

import com.madamepapier.schedulism.models.ShiftRotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShiftRotationRepository extends JpaRepository<ShiftRotation, Long> {

    List<ShiftRotation> findAllByHasBeenRequestedTrue();

    List<ShiftRotation> findAllByUserIdAndDate(@Param("userId") long userId, @Param("date") LocalDate date);

}
