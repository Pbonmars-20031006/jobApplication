package com.priyanshu.firstJobApp.reviews;

import com.priyanshu.firstJobApp.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> findAll(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.findAll(companyId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{id}") //path var id
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,@PathVariable Long id){
        Review found=reviewService.getReviewById(companyId,id);

        if(found!=null)
            return new ResponseEntity<>(found, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId,@RequestBody Review review){
        boolean isCreated =reviewService.createReview(companyId,review);

        if(isCreated)
            return new ResponseEntity<>("Review Posted Succesfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Sorry! Review wasn't saved.",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId,@PathVariable Long id, @RequestBody Review review){
        boolean updated = reviewService.updateReviewById(companyId,id, review);

        if(updated)
            return new ResponseEntity<>("Review has been updated succesfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Sorry we encoutered an error, please try again", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deleteReviewById( @PathVariable Long companyId,@PathVariable Long id){
        boolean deleted = reviewService.deleteReviewById(companyId,id);

        if(deleted)
            return new ResponseEntity<>("Review has been deleted succesfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Sorry we encoutered an error, please try again", HttpStatus.NOT_FOUND);
    }
}


