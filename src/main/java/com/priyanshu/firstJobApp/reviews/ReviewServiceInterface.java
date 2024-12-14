package com.priyanshu.firstJobApp.reviews;

import java.util.List;


public interface ReviewServiceInterface {

    List<Review> findAll();
    Review getReviewById(Long id);
    void createReview(Review review);
    boolean deleteReviewById(Long id);
    boolean updateReviewById(Long id, Review review);


}
