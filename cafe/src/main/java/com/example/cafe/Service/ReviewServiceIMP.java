package com.example.cafe.Service;


import com.example.cafe.Entity.ReviewEntity;
import com.example.cafe.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceIMP implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public ReviewEntity reviewsave(ReviewEntity reviewEntity) {
        return reviewRepository.save(reviewEntity );
    }

    @Override
    public Page<ReviewEntity> reviewlist(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }
}
