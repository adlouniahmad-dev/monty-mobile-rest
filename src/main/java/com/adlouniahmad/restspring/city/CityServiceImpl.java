package com.adlouniahmad.restspring.city;

import com.adlouniahmad.restspring.country.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> findAllByCountry(Country country) {
        return cityRepository.findAllByCountry(country);
    }
}
