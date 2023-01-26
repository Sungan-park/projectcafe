package com.example.cafe.Repository;

import com.example.cafe.DTO.Cafe;
import com.example.cafe.Entity.CafeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Long> {
    CafeEntity save(CafeEntity cafeEntity);

    Page<CafeEntity> findByCnameContaining(String keyword, Pageable pageable);

    Page<CafeEntity> findByCtypeEquals(String ctype, Pageable pageable);
}
