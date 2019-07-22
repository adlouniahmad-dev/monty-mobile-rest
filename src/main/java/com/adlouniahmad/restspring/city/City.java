package com.adlouniahmad.restspring.city;

import com.adlouniahmad.restspring.core.BaseEntity;
import com.adlouniahmad.restspring.country.Country;
import com.adlouniahmad.restspring.person.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City extends BaseEntity {

    private String name;

    @ManyToOne
    @JsonIgnoreProperties("cities")
    private Country country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Person> people;

    public City() {
        super();
        people = new ArrayList<>();
    }

    public City(String name) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPerson(Person person) {
        this.people.add(person);
    }
}
