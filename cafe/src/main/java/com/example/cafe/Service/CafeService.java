package com.example.cafe.Service;

import com.example.cafe.Entity.CafeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CafeService {

    /*Page<CafeEntity> list(int page);*/

    Page<CafeEntity> cafelist(Pageable pageable);

    CafeEntity cafesave(CafeEntity cafeEntity);

    Page<CafeEntity> cafeSearchList(String keyword, Pageable pageable);

    Page<CafeEntity> typelist(String ctype, Pageable pageable);


}
