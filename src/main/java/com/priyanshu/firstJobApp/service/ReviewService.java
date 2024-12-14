package com.priyanshu.firstJobApp.service;
import com.priyanshu.firstJobApp.reviews.Review;
import com.priyanshu.firstJobApp.reviews.ReviewServiceInterface;
import com.priyanshu.firstJobApp.repository.reviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements ReviewServiceInterface {


    reviewRepository ReviewRepository;

    public ReviewService(reviewRepository reviewRepository) {
        ReviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return ReviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Long id) { //??? // hhehehehheh fixed
        return  ReviewRepository.findById(id).orElse(null);
    }

    @Override
    public void createReview(Review review) {
        ReviewRepository.save(review);
    }

    @Override
    public boolean deleteReviewById(Long id) {
       try{
           ReviewRepository.deleteById(id);
           return true;
       }catch(Exception e){
           return false;
       }
    }

    @Override
    public boolean updateReviewById(Long id, Review review) {
        Optional<Review> reviewOptional = ReviewRepository.findById(id);

        if (reviewOptional.isPresent()) {
            Review existingRecview = reviewOptional.get();
            if (review.getTitle() != null) {
                existingRecview.setTitle(review.getTitle());
            }
            if (review.getDate() != null) {
                existingRecview.setDate(review.getDate());
            }
            if (review.getDescription() != null) {
                existingRecview.setDescription(review.getDescription());
            }
            if (review.getJobId() != null) {
                existingRecview.setJobId(review.getJobId());
            }

            ReviewRepository.save(existingRecview);
            return true;
        }
        return false;
    }
}
