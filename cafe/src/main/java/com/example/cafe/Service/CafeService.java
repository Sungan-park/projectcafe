package com.example.cafe.Service;

import com.example.cafe.Entity.CafeEntity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

public interface CafeService {

    Page<CafeEntity> list(int page);


    CafeEntity cafesave(CafeEntity cafeEntity);

    ArrayList<CafeEntity> out();
}
