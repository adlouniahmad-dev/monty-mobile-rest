package com.adlouniahmad.restspring.city;

import com.adlouniahmad.restspring.country.Country;

import java.util.List;

public interface CityService {

    List<City> findAllCities();

    List<City> findAllByCountry(Country country);
}
