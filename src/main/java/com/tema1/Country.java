package com.tema1;

import com.tema1.data.IEntitateFisier;

import java.util.Objects;

public class Country implements IEntitateFisier {
    private Integer id;
    private String countryCode;

    public Country(int id, String countryCode) {
        this.id = id;
        this.countryCode = countryCode;
    }

    public Country() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
