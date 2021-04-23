package dev.johnmedeiros.waterBnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.waterBnb.models.Listing;
import dev.johnmedeiros.waterBnb.repositories.ListingRepository;


@Service
public class ListingService {
	
private final ListingRepository listingRepository;
    
    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    
    // returns all the listings
    public List<Listing> allListings() {
        return listingRepository.findAll();
    }
    
    
    // retrieves a listing by id
    public Listing findListing(Long id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if(optionalListing.isPresent()) {
            return optionalListing.get();
        } else {
            return null;
        }
    }
  
  // saves a listing (either to update or create new)
    public Listing saveListing(Listing l) {
        return listingRepository.save(l);
    }
    
	// searches for an listing
	public List<Listing> searchListing(String search) {
		return listingRepository.findByAddressContaining(search);
	}
	
    
    // deletes a review
    public void deleteListing(Long id) {
    	listingRepository.deleteById(id);
    }
    


}
