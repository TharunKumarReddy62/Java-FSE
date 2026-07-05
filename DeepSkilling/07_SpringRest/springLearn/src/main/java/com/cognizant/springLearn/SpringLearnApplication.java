package com.cognizant.springLearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws Exception {

		//LOGGER.info("Spring Boot Application Started");

		SpringApplication.run(SpringLearnApplication.class, args);
		//displayDate();
		//displayCountry();   // Exercise 4
		displayCountries();


		//LOGGER.info("Application Running Successfully");
	}
	public static void displayDate() throws Exception{
		LOGGER.info("START");

		ApplicationContext context= new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat",SimpleDateFormat.class);
		Date date = format.parse("31/12/26");
		//System.out.println(date);
		LOGGER.debug("Parsed Date : {}", date);

		LOGGER.info("END");

	}
	public static void displayCountry() {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		Country country =  context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country);
		LOGGER.debug("Country : {}", anotherCountry);

		LOGGER.info("END");
	}

	public static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = context.getBean("countryList", List.class);
		for(Country country : countries) {
			LOGGER.debug("Country : {}", country);
		}
		LOGGER.info("END");
	}
}


