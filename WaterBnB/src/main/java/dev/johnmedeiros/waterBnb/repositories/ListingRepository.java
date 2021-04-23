package dev.johnmedeiros.waterBnb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.waterBnb.models.Listing;


@Repository
public interface ListingRepository extends CrudRepository <Listing, Long> {
	
	  List<Listing> findAll();

	  Optional<Listing> findById(Long id);
	  
	  List<Listing> findByAddressContaining(String search);
	  
	  void deleteById(Long id);
	  

}
