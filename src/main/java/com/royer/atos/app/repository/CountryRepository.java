package com.royer.atos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.royer.atos.app.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
