package dev.johnmedeiros.waterBnb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.waterBnb.models.Review;


@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	  List<Review> findAll();

	  Optional<Review> findById(Long id);
	  
	  void deleteById(Long id);
	

}
