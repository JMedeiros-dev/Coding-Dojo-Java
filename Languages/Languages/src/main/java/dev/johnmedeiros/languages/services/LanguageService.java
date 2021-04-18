package dev.johnmedeiros.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.languages.models.Language;
import dev.johnmedeiros.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    
    // creates a language
    public Language createLanguage(Language language) {
    	return languageRepository.save(language);
    }
    
    // retrieves a language
    public Language findLanguage(Long id) {
    	Optional<Language> optionalLanguage = languageRepository.findById(id);
    	if(optionalLanguage.isPresent()) {
    		return optionalLanguage.get();
    	} else {
    		return null;
    	}
    }
    
    // updates a language
    public Language updateLanguage(Language language) {
    	return languageRepository.save(language);
    }
    
    // deletes a language    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
}
