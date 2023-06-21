package com.example.directpay.Controller;

import com.example.directpay.Entity.Country;
import com.example.directpay.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
@CrossOrigin
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {

        this.countryService = countryService;
    }

    @GetMapping("/language/{language}")
    public Country[] getCountryByCurrency(@PathVariable String language) {
        return countryService.getCountriesByLanguage(language);
    }
}
