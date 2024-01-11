package com.madamepapier.schedulism.repositories;

import com.madamepapier.schedulism.models.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftTypeRepository extends JpaRepository<ShiftType, Long> {
//

}
