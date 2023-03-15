package com.tema1.dto;

import com.tema1.data.IEntitateFisier;

public class PublishingRetailerCountry implements IEntitateFisier {
    private Integer publishingRetailerID;
    private Integer countryID;

    public PublishingRetailerCountry() {
    }

    public PublishingRetailerCountry(Integer publishingRetailerID, Integer countryID) {
        this.publishingRetailerID = publishingRetailerID;
        this.countryID = countryID;
    }

    public Integer getPublishingRetailerID() {
        return publishingRetailerID;
    }

    public void setPublishingRetailerID(Integer publishingRetailerID) {
        this.publishingRetailerID = publishingRetailerID;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    @Override
    public String toString() {
        return "PublishingRetailerCountry{" +
                "publishingRetailerID=" + publishingRetailerID +
                ", countryID=" + countryID +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
