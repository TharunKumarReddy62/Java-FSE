package com.cognizant.SpringJPA.service;

import com.cognizant.SpringJPA.model.Country;
import com.cognizant.SpringJPA.repository.CountryRepository;
import com.cognizant.SpringJPA.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (result.isEmpty()) {
            throw new CountryNotFoundException(
                    "Country not found with code : " + countryCode);
        }

        return result.get();
    }


    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name)
            throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(code);

        if (result.isEmpty()) {
            throw new CountryNotFoundException(
                    "Country not found with code : " + code);
        }

        Country country = result.get();

        country.setName(name);

        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String countryCode) {

        countryRepository.deleteById(countryCode);

    }
}