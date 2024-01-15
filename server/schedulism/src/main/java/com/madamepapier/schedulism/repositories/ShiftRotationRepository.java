package com.madamepapier.schedulism.repositories;

import com.madamepapier.schedulism.models.ShiftRotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRotationRepository extends JpaRepository<ShiftRotation, Long> {
//    test
//    SELECT * FROM shift_rotation WHERE shift_type={id} AND user_id={id}

//List<Subscription> findByChatRoomIdAndUserId(Long chatRoomId, Long userId);

    ShiftRotation findByShiftTypeIdAndUserId(Long shiftTypeId, Long userId);

}
