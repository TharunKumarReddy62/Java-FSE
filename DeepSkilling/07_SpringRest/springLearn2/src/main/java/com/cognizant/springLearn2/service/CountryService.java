package com.cognizant.springLearn2.service;

import com.cognizant.springLearn2.exception.CountryNotFoundException;
import com.cognizant.springLearn2.model.Country;
import com.cognizant.springLearn2.model.CountryList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {

    public Country getCountry(String code) {

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        CountryList countryList = context.getBean("countryList", CountryList.class);
        /* return countryList.getCountryList().stream().filter(country ->country.getCode().equalsIgnoreCase(code))
                .findFirst()
               .orElse(null);

         */

        List<Country> countries = countryList.getCountryList();
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        throw new CountryNotFoundException();}

}
