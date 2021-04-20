package dev.johnmedeiros.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.relationships.models.License;
import dev.johnmedeiros.relationships.models.Person;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	

	
	
}
