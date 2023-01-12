package com.example.cafe.Repository;

import com.example.cafe.Entity.CafeEntity;
import com.example.cafe.Entity.JoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinRepository extends JpaRepository<JoinEntity, Long> {

}
