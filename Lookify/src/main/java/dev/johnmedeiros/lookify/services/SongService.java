package dev.johnmedeiros.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.lookify.models.Song;
import dev.johnmedeiros.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		
		this.songRepository = songRepository;
	}
	
	// returns all songs
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	// creates a song
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	
	// retrieves a song
    public Song findSong(Long id) {
    	Optional<Song> optionalSong = songRepository.findById(id);
    	if(optionalSong.isPresent()) {
    		return optionalSong.get();
    	} else {
    		return null;
    	}
    }
	
	public List<Song> highestRated() {
		return songRepository.findByOrderByRatingDesc();
	}
	
	// deletes a song by id
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}

	// searches for an artist
	public List<Song> searchArtist(String search) {
		return songRepository.findByArtistContaining(search);
		
	}

}
