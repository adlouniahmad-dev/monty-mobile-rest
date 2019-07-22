package com.adlouniahmad.restspring.country;

import com.adlouniahmad.restspring.city.City;
import com.adlouniahmad.restspring.core.BaseEntity;
import com.adlouniahmad.restspring.person.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country extends BaseEntity {

    @NotNull
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Person> people;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<City> cities;

    public Country() {
        super();
        people = new ArrayList<>();
        cities = new ArrayList<>();
    }

    public Country(String name) {
        this();
        this.name = name;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPerson(Person person) {
        this.people.add(person);
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCity(City city) {
        this.cities.add(city);
    }
}
