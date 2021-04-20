package dev.johnmedeiros.relationships.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.relationships.models.Person;
import dev.johnmedeiros.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


	   // returns all the persons
    public List<Person> allPersons() {
        return personRepository.findAll();
    }
    // creates a person
    public Person createPerson(Person person) {
        return personRepository.save(person);
	}
    
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
    
}

