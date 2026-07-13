package com.cognizant.SpringJPA.repository;

import com.cognizant.SpringJPA.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}