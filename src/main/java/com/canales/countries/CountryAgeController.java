package com.canales.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    // http://localhost:2020/age/age/25
    @GetMapping(value = "/age/{number}")
    public ResponseEntity<?> getByMedianAge(@PathVariable long number){
        List<Country> byAge = CountriesApplication.mainCountryList.findCountries(c -> c.getMedianAge() >= number);
        return new ResponseEntity<>(byAge, HttpStatus.OK);
    }
   // http://localhost:2020/age/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getByMinAge(){
        CountriesApplication.mainCountryList.countryList.sort((c1, c2) -> (int) (c1.getMedianAge() - c2.getMedianAge()));
        return new ResponseEntity<>(CountriesApplication.mainCountryList.countryList.get(0), HttpStatus.OK);
    }
   // http://localhost:2020/age/max
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getByMaxAge(){
        CountriesApplication.mainCountryList.countryList.sort((c1, c2) -> (int) (c2.getMedianAge() - c1.getMedianAge()));
        return new ResponseEntity<>(CountriesApplication.mainCountryList.countryList.get(0), HttpStatus.OK);
    }
    // * STRETCH * - http://localhost:2020/age/median
    @GetMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getByMedian(){
        CountriesApplication.mainCountryList.countryList.sort((c1, c2) -> (int) (c1.getMedianAge() - c2.getMedianAge()));
        return new ResponseEntity<>(CountriesApplication.mainCountryList.countryList.get(CountriesApplication.mainCountryList.countryList.size() / 2), HttpStatus.OK);
    }
}
