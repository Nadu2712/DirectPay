package com.example.directpay.Service;

import com.example.directpay.Entity.Country;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {

    private final RestTemplate restTemplate;

    public CountryService() {
        this.restTemplate = new RestTemplate();
    }

    public Country[] getCountriesByLanguage(String language) {
        String url = "https://restcountries.com/v3.1/lang/" + language;

        ResponseEntity<Country[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Country[].class, language);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve countries: " + response.getStatusCode());
        }
    }

}
