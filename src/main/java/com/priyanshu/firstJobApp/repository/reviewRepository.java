package com.priyanshu.firstJobApp.repository;

import com.priyanshu.firstJobApp.reviews.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository extends JpaRepository<Review,Long> {
}
