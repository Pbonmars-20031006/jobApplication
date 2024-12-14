package com.priyanshu.firstJobApp.service;
import com.priyanshu.firstJobApp.company.Company;
import com.priyanshu.firstJobApp.reviews.Review;
import com.priyanshu.firstJobApp.reviews.ReviewServiceInterface;
import com.priyanshu.firstJobApp.repository.reviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements ReviewServiceInterface {


    private final reviewRepository ReviewRepository;
    private final CompanyService companyService;

    public ReviewService(reviewRepository reviewRepository,CompanyService companyService) {
        this.ReviewRepository = reviewRepository;
        this.companyService=companyService;
    }

    @Override
    public List<Review> findAll(Long companyId) {
        return ReviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review getReviewById(Long companyId,Long id) { //??? // hhehehehheh fixed

        List<Review> reviews= ReviewRepository.findByCompanyId(companyId);

        return reviews.stream().filter(review -> review.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean createReview(Long companyId,Review review) {
        Company company=companyService.getCompanyById(companyId);
        if(company!=null) {
            review.setCompany(company);
            ReviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long companyId,Long id) {
      if(companyService.getCompanyById(companyId)!=null && ReviewRepository.existsById(id)){
          try{
              Review review =ReviewRepository.findById(id).orElse(null);
              Company company=review.getCompany();
              company.getReview().remove(review);
              companyService.updateCompanyById(companyId,company);
              ReviewRepository.deleteById(id);
          }catch(Exception e){
              return false;
          }
      }
      return false;
    }

    @Override
    public boolean updateReviewById(Long companyId, Long id, Review updatedReview) {
        // Check if the company exists
        if (companyService.getCompanyById(companyId) == null) {
            return false;
        }

        // Find the review by companyId and id
        List<Review> reviews = ReviewRepository.findByCompanyId(companyId);
        Review reviewOptional = reviews.stream().filter(review -> review.getId().equals(id)).findFirst().orElse(null);

        if (reviewOptional != null) {
            // Update the fields if they are not null
            reviewOptional.setCompany(companyService.getCompanyById(id));
            if (updatedReview.getTitle() != null) {
                reviewOptional.setTitle(updatedReview.getTitle());
            }
            if (updatedReview.getRating() != null) {
                reviewOptional.setRating(updatedReview.getRating());
            }
            if (updatedReview.getDescription() != null) {
                reviewOptional.setDescription(updatedReview.getDescription());
            }

            // Save the updated review
            ReviewRepository.save(reviewOptional);
            return true;
        }

        return false;
    }

}
