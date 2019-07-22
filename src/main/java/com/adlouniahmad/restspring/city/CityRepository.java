package com.adlouniahmad.restspring.city;

import com.adlouniahmad.restspring.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c where c.country = ?1")
    List<City> findAllByCountry(Country country);
}
