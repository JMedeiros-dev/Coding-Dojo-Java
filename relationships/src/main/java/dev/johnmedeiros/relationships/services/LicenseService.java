package dev.johnmedeiros.relationships.services;



import org.springframework.stereotype.Service;

import dev.johnmedeiros.relationships.models.License;
import dev.johnmedeiros.relationships.models.Person;
import dev.johnmedeiros.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
private final LicenseRepository licenseRepository;
    
    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

 // creates a license
    public License createLicense(License license) {
        return licenseRepository.save(license);
	}
      
}



