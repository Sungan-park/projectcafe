package com.example.cafe.Service;

import com.example.cafe.DTO.Cafe;
import com.example.cafe.Entity.CafeEntity;
import com.example.cafe.Repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CafeServiceIMP implements CafeService{

    @Autowired
    CafeRepository cafeRepository;


    @Override
    public Page<CafeEntity> cafelist(Pageable pageable) {
        return cafeRepository.findAll(pageable);
    }

    @Override
    public CafeEntity cafesave(CafeEntity cafeEntity) {
        return cafeRepository.save(cafeEntity);
    }

    @Override
    public Page<CafeEntity> cafeSearchList(String keyword, Pageable pageable) {
        return cafeRepository.findByCnameContaining(keyword, pageable);
    }






}
