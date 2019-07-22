package com.adlouniahmad.restspring.city;

import com.adlouniahmad.restspring.country.Country;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(CityController.BASE_URL)
public class CityController {

    static final String BASE_URL = "/api/v1/cities";

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getCities() {
        return cityService.findAllCities();
    }

    @PostMapping
    public List<City> getCitiesByCountry(@Valid @RequestBody Country country) {
        return cityService.findAllByCountry(country);
    }
}
