package com.royer.atos.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royer.atos.app.models.Language;
import com.royer.atos.app.repository.LanguageRepository;

@Service
public class LanguageService {

	@Autowired LanguageRepository languageRepository;
	
	public List<Language> getAllLanguages(){
		List<Language> languages = new ArrayList<Language>();
		languageRepository.findAll().forEach(languages::add);
		return languages;
	}
}
