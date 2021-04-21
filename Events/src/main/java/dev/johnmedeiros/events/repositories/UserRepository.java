package dev.johnmedeiros.events.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.events.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
	List<User> findAll();
	
	Optional<User> findById(Long id);
	
	User findByEmail(String email);
	
	void deleteById(Long id);
}
