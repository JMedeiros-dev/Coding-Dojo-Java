package dev.johnmedeiros.dojosAndNinjas.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.dojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

	// this method retrieves all the ninjas from the database
	List<Ninja> findAll();

	//this method finds a ninja by ID
	Optional<Ninja> findById(Long id);

	//this method deletes a ninja by ID
	void deleteById(Long id);

		
	
}
