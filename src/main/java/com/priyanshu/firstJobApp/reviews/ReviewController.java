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

    @GetMapping
    public ResponseEntity<List<Review>> findAll(){
        return new ResponseEntity<>(reviewService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") //path var id
    public ResponseEntity<Review> getReviewById(@PathVariable Long id){
        Review found=reviewService.getReviewById(id);

        if(found!=null)
            return new ResponseEntity<>(found, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Review review){
        reviewService.createReview(review);

        return new ResponseEntity<>("Review Posted Succesfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long id, @RequestBody Review review){
        boolean updated = reviewService.updateReviewById(id, review);

        if(updated)
            return new ResponseEntity<>("Review has been updated succesfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Sorry we encoutered an error, please try again", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long id){
        boolean deleted = reviewService.deleteReviewById(id);

        if(deleted)
            return new ResponseEntity<>("Review has been deleted succesfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Sorry we encoutered an error, please try again", HttpStatus.NOT_FOUND);
    }
}


