package com.example.cafe.Service;

import com.example.cafe.Entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    ReviewEntity reviewsave(ReviewEntity reviewEntity);

    Page<ReviewEntity> reviewlist(Pageable pageable);
}
