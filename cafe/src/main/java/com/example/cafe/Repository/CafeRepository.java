package com.example.cafe.Repository;

import com.example.cafe.Entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Long> {
    CafeEntity save(CafeEntity cafeEntity);
}
