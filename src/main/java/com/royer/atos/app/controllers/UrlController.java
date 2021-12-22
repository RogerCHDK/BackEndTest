package com.royer.atos.app.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royer.atos.app.service.UrlService;

@RestController
@RequestMapping("/image")
public class UrlController {

	@Autowired UrlService service;
	
	@GetMapping
	public CompletableFuture<ResponseEntity<String>> getURl() {
		return service.getUrl().thenApplyAsync( data -> {
			return new ResponseEntity<String>(data,  new HttpHeaders(), HttpStatus.OK);
		});
		
	}
}
