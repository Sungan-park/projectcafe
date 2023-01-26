package com.example.cafe.Service;

import com.example.cafe.Entity.CafeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CafeService {

 
    /*카페 불러오기+페이징*/
    Page<CafeEntity> cafelist(Pageable pageable);
    /*카페 등록*/
    CafeEntity cafesave(CafeEntity cafeEntity);
    /*카페 검색*/
    Page<CafeEntity> cafeSearchList(String keyword, Pageable pageable);
    /*카페 타입별 불러오기*/
    Page<CafeEntity> typelist(String ctype, Pageable pageable);

    /*특정 게시물 불러오기 상세페이지*/
    CafeEntity cafedetail(Long id);
}
