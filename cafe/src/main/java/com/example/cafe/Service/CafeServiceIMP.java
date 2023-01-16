package com.example.cafe.Service;

import com.example.cafe.Entity.CafeEntity;
import com.example.cafe.Repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CafeServiceIMP implements CafeService{

    @Autowired
    CafeRepository cafeRepository;

    @Override
    public Page<CafeEntity> list(int page) {
        return cafeRepository.findAll(PageRequest.of(page,3, Sort.by(Sort.Direction.ASC,"id")));
    }

    @Override
    public CafeEntity cafesave(CafeEntity cafeEntity) {
        return cafeRepository.save(cafeEntity);
    }

    @Override
    public ArrayList<CafeEntity> out() {
        return (ArrayList<CafeEntity>)  cafeRepository.findAll();
    }
}
