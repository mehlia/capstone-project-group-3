package com.madamepapier.schedulism.repositories;

import com.madamepapier.schedulism.models.ShiftRotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRotationRepository extends JpaRepository<ShiftRotation, Long> {

    List<ShiftRotation> findAllByHasBeenRequestedTrue();

}
