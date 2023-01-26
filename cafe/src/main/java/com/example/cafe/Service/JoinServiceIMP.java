package com.example.cafe.Service;

import com.example.cafe.Entity.JoinEntity;
import com.example.cafe.Repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceIMP implements JoinService{
    @Autowired
    JoinRepository joinRepository;

    @Override
    public JoinEntity joinsave(JoinEntity joinEntity) {
        return joinRepository.save(joinEntity);
    }



}
