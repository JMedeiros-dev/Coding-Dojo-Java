package dev.johnmedeiros.dojosAndNinjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.dojosAndNinjas.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {

// this method retrieves all the dojos from the database
List<Dojo> findAll();

//this method finds a dojo by ID
Optional<Dojo> findById(Long id);

//this method deletes a dojo by ID
void deleteById(Long id);

	
}
