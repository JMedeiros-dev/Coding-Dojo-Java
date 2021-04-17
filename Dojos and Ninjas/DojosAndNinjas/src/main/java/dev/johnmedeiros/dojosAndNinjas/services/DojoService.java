package dev.johnmedeiros.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.dojosAndNinjas.models.Dojo;
import dev.johnmedeiros.dojosAndNinjas.repositories.DojoRepo;

@Service
public class DojoService {

	private final DojoRepo dojoRepo;

	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}

	// returns all the dojos

	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}


	// creates a dojo

	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}


	// retrieves a dojo

	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	// deletes a dojo
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}

}
