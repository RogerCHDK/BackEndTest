package com.royer.atos.app.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royer.atos.app.models.Country;
import com.royer.atos.app.service.CountryService;


@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired CountryService service;
	
	@GetMapping
	public  CompletableFuture<ResponseEntity<List<Country>>> index(){
		return service.getAllCountries().thenApplyAsync( countries -> {
			return new ResponseEntity<List<Country>>(countries, new HttpHeaders(), HttpStatus.OK);
		});
	}
	
	@PostMapping
	public CompletableFuture<ResponseEntity<Country>> createOrUpdateCountry( Country country ){
		return service.createOrUpdateCountry(country).thenApplyAsync( countryUpdate -> {
			return new ResponseEntity<Country>(countryUpdate, new HttpHeaders(), HttpStatus.CREATED);
		});
	}
	
	@GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Country>> getEmployeeById(@PathVariable("id") Integer id) throws InterruptedException{
		return service.getByID(id).thenApplyAsync( country -> {
			return new ResponseEntity<Country>(country, new HttpHeaders(), HttpStatus.OK);
		});
	}
	
	 @DeleteMapping("/{id}")
	    public HttpStatus deleteEmployeeById(@PathVariable("id") Integer id) {
		 service.deleteCountryById(id);
		 return HttpStatus.NO_CONTENT;
	 }
} 
