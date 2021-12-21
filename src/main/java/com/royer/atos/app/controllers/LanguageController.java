package com.royer.atos.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royer.atos.app.models.Language;
import com.royer.atos.app.service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {
	@Autowired LanguageService service;

	@GetMapping
	public ResponseEntity<List<Language>> index(){
		List<Language> languageList = service.getAllLanguages();
		return new ResponseEntity<List<Language>>(languageList, new HttpHeaders(), HttpStatus.OK);
	}
}
