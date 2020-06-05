package com.canales.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {

    public static CountryList mainCountryList;

    public static void main(String[] args) {
        mainCountryList = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
