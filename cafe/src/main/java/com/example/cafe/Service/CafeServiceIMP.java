package com.example.cafe.Service;

import com.example.cafe.Entity.CafeEntity;
import com.example.cafe.Repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeServiceIMP implements CafeService{

    @Autowired
    CafeRepository cafeRepository;

    @Override
    public CafeEntity cafesave(CafeEntity cafeEntity) {
        return cafeRepository.save(cafeEntity);
    }
}
