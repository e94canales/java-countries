package com.canales.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {

    // http://localhost:2020/population/size/1000000000
    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getByPopulation(@PathVariable long number){
        List<Country> popList = CountriesApplication.mainCountryList.findCountries(c -> c.getPopulation() >= number);
       return new ResponseEntity<>(popList, HttpStatus.OK);
   }

   // http://localhost:2020/population/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getMinPopulation(){
        CountriesApplication.mainCountryList.countryList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(CountriesApplication.mainCountryList.countryList.get(0), HttpStatus.OK);
    }

    // http://localhost:2020/population/min
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxPopulation(){
        CountriesApplication.mainCountryList.countryList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(CountriesApplication.mainCountryList.countryList.get(0), HttpStatus.OK);
    }
    // * STRETCH * - http://localhost:2020/population/median
    @GetMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getByMedian(){
        CountriesApplication.mainCountryList.countryList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(CountriesApplication.mainCountryList.countryList.get(CountriesApplication.mainCountryList.countryList.size() / 2), HttpStatus.OK);
    }
}
