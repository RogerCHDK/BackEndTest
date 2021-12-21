package com.royer.atos.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.royer.atos.app.models.Country;
import com.royer.atos.app.repository.CountryRepository;


@Service
public class CountryService {

	@Autowired CountryRepository countryRepository;
	
	@Async
	public CompletableFuture<List<Country>> getAllCountries(){
		List<Country> countries = new ArrayList<Country>();
		countryRepository.findAll().forEach(countries::add);
		return CompletableFuture.completedFuture(countries);
	}
	
	@Async
	public CompletableFuture<Country> getByID(Integer countryID) throws InterruptedException{
		Optional<Country> country = countryRepository.findById(countryID); 
		return CompletableFuture.completedFuture(country.get());
	}
	
	@Async
	public CompletableFuture<Country> createOrUpdateCountry( Country entity ) {
		Optional<Country> country = countryRepository.findById(entity.getId()); 
		
		if (country.isPresent()) {
			Country newEntity = country.get();
			newEntity.setName(entity.getName());
			newEntity.setPopulation(entity.getPopulation());
			newEntity = countryRepository.save(newEntity);
			return CompletableFuture.completedFuture(newEntity);
		} else {

			entity = countryRepository.save(entity);
			
			return CompletableFuture.completedFuture(entity);
		}
	}
	
	public void deleteCountryById(Integer countryID) {
		Optional<Country> country = countryRepository.findById(countryID); 
		if(country.isPresent()) 
        {
			countryRepository.deleteById(countryID);
        }
	}
}
