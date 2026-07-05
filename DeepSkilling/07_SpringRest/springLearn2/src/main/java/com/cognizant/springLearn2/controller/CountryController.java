package com.cognizant.springLearn2.controller;

import com.cognizant.springLearn2.exception.CountryNotFoundException;
import com.cognizant.springLearn2.model.Country;
import com.cognizant.springLearn2.model.CountryList;
import com.cognizant.springLearn2.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);


    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country");
        LOGGER.info("End");
        return country;

    }



    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        CountryList countryList = context.getBean("countryList", CountryList.class);
        LOGGER.info("END");
        return countryList.getCountryList();
    }

    @Autowired
    private CountryService countryService;
    @GetMapping("/countries/{code}")
    public Country getCountry (@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START");
        Country country = countryService.getCountry(code);
        LOGGER.info("END");
        return country;
    }

}
