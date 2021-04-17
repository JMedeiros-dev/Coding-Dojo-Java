package dev.johnmedeiros.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.dojosAndNinjas.models.Ninja;
import dev.johnmedeiros.dojosAndNinjas.repositories.NinjaRepo;

@Service
public class NinjaService {


	private final NinjaRepo ninjaRepo;

	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	// returns all the ninja

	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}


	// creates a ninja

	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}


	// retrieves a ninja

	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	// deletes a ninja
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}

}

