package dev.johnmedeiros.events.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.johnmedeiros.events.models.Event;





public interface EventRepository extends CrudRepository<Event, Long> {

	List<Event> findAll();
	
	Optional<Event> findById(Long id);
	

	void deleteById(Long id);
	
}
