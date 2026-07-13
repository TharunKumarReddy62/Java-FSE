package com.cognizant.SpringJPA;

import com.cognizant.SpringJPA.model.Country;
import com.cognizant.SpringJPA.service.CountryService;
import com.cognizant.SpringJPA.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringJpaApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {

		//SpringApplication.run(SpringJpaApplication.class, args);
		//LOGGER.info(" Inside main()");
		ApplicationContext context =
			SpringApplication.run(SpringJpaApplication.class, args);

		countryService = context.getBean(CountryService.class);

		//testGetAllCountries();
		//testFindCountryByCode();
		//testAddCountry();
		//testUpdateCountry();
		//testDeleteCountry();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("Countries = {}", countries);

		LOGGER.info("End");
	}

	private static void testFindCountryByCode() {

		LOGGER.info("Start");

		try {

			Country country = countryService.findCountryByCode("IND");

			LOGGER.debug("Country : {}", country);

		} catch (CountryNotFoundException e) {

			LOGGER.error(e.getMessage());

		}

		LOGGER.info("End");
	}

	private static void testAddCountry() {

		LOGGER.info("Start");

		Country country = new Country("TS", "Telangana");

		countryService.addCountry(country);

		try {

			Country addedCountry = countryService.findCountryByCode("TS");

			LOGGER.debug("Added Country : {}", addedCountry);

		} catch (CountryNotFoundException e) {

			LOGGER.error(e.getMessage());

		}

		LOGGER.info("End");
	}


	private static void testUpdateCountry() {

		LOGGER.info("Start");

		try {

			countryService.updateCountry("TS", "Telangana State");

			Country country = countryService.findCountryByCode("TS");

			LOGGER.debug("Updated Country : {}", country);

		} catch (CountryNotFoundException e) {

			LOGGER.error(e.getMessage());

		}

		LOGGER.info("End");
	}


	private static void testDeleteCountry() {

		LOGGER.info("Start");

		countryService.deleteCountry("TS");

		try {

			Country country = countryService.findCountryByCode("TS");

			LOGGER.debug("Country : {}", country);

		} catch (CountryNotFoundException e) {

			LOGGER.info("Country deleted successfully.");

		}

		LOGGER.info("End");
	}
}

