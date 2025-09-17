package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/cat")
public class CatFactsController {

    final String API_URL = "https://catfact.ninja/fact";

    @GetMapping("/fact")
    public String getFact() {
        
        RestTemplate restTemplate = new RestTemplate();
        CatFact fact = restTemplate.getForObject(API_URL, CatFact.class);
        return fact.getFact();
    }
    

}
