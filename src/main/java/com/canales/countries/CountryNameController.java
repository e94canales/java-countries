package com.canales.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/names")
public class CountryNameController {

    // http://localhost:2020/names/all
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountryNames(){
        CountriesApplication.mainCountryList.countryList.sort((c1,  c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.mainCountryList.countryList, HttpStatus.OK);
    }

    // http://localhost:2020/names/start/e - not case sensitive
    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesBeginningWith(@PathVariable char letter){
       List<Country> returnCountries = CountriesApplication.mainCountryList.findCountries(c -> (c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter)));
        returnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    // http://localhost:2020/names/size/20
    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLength(@PathVariable long number){
        List<Country> returnCountriesByLength = CountriesApplication.mainCountryList.findCountries(c -> c.getName().length() >= number);
        returnCountriesByLength.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnCountriesByLength, HttpStatus.OK);
    }


}
