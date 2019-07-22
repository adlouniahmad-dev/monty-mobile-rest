package com.adlouniahmad.restspring.person;

import com.adlouniahmad.restspring.city.City;
import com.adlouniahmad.restspring.core.BaseEntity;
import com.adlouniahmad.restspring.country.Country;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Person extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private int mobile;

    @NotNull
    private String address;

    @NotNull
    private String notes;

    @NotNull
    @ManyToOne
    @JsonIgnoreProperties("people")
    private Country country;

    @NotNull
    @ManyToOne
    @JsonIgnoreProperties("people")
    private City city;

    public Person() {
        super();
    }

    public Person(String name, int mobile, String address, String notes, Country country, City city) {
       this();
       this.name = name;
       this.mobile = mobile;
       this.address = address;
       this.notes = notes;
       this.country = country;
       this.city = city;
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

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", mobile=" + mobile +
                ", address='" + address + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
