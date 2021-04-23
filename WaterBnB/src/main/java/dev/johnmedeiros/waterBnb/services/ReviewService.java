package dev.johnmedeiros.waterBnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.waterBnb.models.Review;
import dev.johnmedeiros.waterBnb.repositories.ReviewRepository;


@Service
public class ReviewService {
	
private final ReviewRepository reviewRepository;
    
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    
    // returns all the reviews
    public List<Review> allReviews() {
        return reviewRepository.findAll();
    }
    
    
    // retrieves a review by id
    public Review findReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()) {
            return optionalReview.get();
        } else {
            return null;
        }
    }
  
  // saves a review (either to update or create new)
    public Review saveReview(Review r) {
        return reviewRepository.save(r);
    }
    
    // deletes a review
    public void deleteReview(Long id) {
    	reviewRepository.deleteById(id);
    }

}
