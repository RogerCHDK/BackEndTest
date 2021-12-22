package com.royer.atos.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UrlService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Async
	public CompletableFuture<String> getUrl(){
		String apiUrl = restTemplate.getForObject("https://restcountries.com/v3.1/all", String.class);
		return CompletableFuture.completedFuture(apiUrl);
	}
}
