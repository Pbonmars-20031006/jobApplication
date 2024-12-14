package com.priyanshu.firstJobApp.reviews;

import java.util.List;


public interface ReviewServiceInterface {

    List<Review> findAll(Long companyId);
    Review getReviewById(Long companyId,Long id);
    boolean createReview(Long companyId,Review review);
    boolean deleteReviewById(Long companyId,Long id);
    boolean updateReviewById(Long companyId,Long id, Review review);


}
