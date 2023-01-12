package com.example.cafe.Repository;

import com.example.cafe.Entity.CafeEntity;
import com.example.cafe.Entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
