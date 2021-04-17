package dev.johnmedeiros.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	// this method retrieves all the songs from the database	
	List<Song> findAll();
	
	//this method finds all the songs by artist containing the search string
	List<Song> findByArtistContaining(String search);
	
	//this method finds a book by ID
  	Optional<Song> findById(Long id);
	
	// this method retrieves all the songs from the database sorted from highest to lowest
	List<Song> findByOrderByRatingDesc();
	
	//this method deletes a song by ID
	void deleteById(Long id);
	
}
