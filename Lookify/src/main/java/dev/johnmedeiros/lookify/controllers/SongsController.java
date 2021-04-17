package dev.johnmedeiros.lookify.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dev.johnmedeiros.lookify.models.Song;
import dev.johnmedeiros.lookify.services.SongService;

@Controller
public class SongsController {
	
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	  //=============================//	
	 //		   Render Routes	    //
	//=============================//	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String Song(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> songs = songService.highestRated();
		Date date = new java.util.Date();
		String strdate = String.format("For %1$tA, %1$tB %1$te %1$tY", date);
		model.addAttribute("date", strdate);
		model.addAttribute("songs", songs);
		
		return "topTen.jsp";
	}
	
	@RequestMapping("/search")
	public String searchResults() {
		return "results.jsp";
	}
	
	
	
	  //=============================//	
	 //		   Post Routes	    	//
	//=============================//	
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
	    if (result.hasErrors()) {
	        return "new.jsp";
	    } else {
	        songService.createSong(song);
	        return "redirect:/dashboard";
	    }
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(@RequestParam(value="artist") String artist, Model model) {
		List<Song> results= songService.searchArtist(artist);
		model.addAttribute("results", results);
		model.addAttribute("artist", artist);
		
            return "results.jsp";
    }
	
	  //=============================//	
	 //		   Delete Route	    	//
	//=============================//
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
	
}
