package com.tema1.service;

import com.tema1.Country;
import com.tema1.PublishingRetailer;
import com.tema1.data.DataCountry;
import com.tema1.data.DataPublishingRetailer;
import com.tema1.data.DataPublishingRetailerCountry;
import com.tema1.dto.PublishingRetailerCountry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PublishingRetailerCountryService {

    public static List<PublishingRetailer> findPublishingRetailersWithCountries(){
        DataPublishingRetailer dataPublishingRetailer = new DataPublishingRetailer();
        DataCountry dataCountry = new DataCountry();
        DataPublishingRetailerCountry dataPublishingRetailerCountry = new DataPublishingRetailerCountry();
        Map<Integer, PublishingRetailer> publishingRwithIds = dataPublishingRetailer.findAllWithIds();
        Map<Integer, Country> countriesWithIds = dataCountry.findAllWithIds();
        List<PublishingRetailerCountry> publishingRetailerCountryList = dataPublishingRetailerCountry.findAll();
        for (PublishingRetailerCountry prc : publishingRetailerCountryList){
            PublishingRetailer publishingRetailer = publishingRwithIds.get(prc.getPublishingRetailerID());
            Country country = countriesWithIds.get(prc.getCountryID());
            publishingRetailer.getCountries().add(country);
        }
        List<PublishingRetailer> publishingRetailerswithCountries = new ArrayList<>();
        for(Map.Entry<Integer, PublishingRetailer> idAndPr : publishingRwithIds.entrySet()){
            PublishingRetailer publishingRetailer = idAndPr.getValue();
            publishingRetailerswithCountries.add(publishingRetailer);
        }

        return publishingRetailerswithCountries;
    }
}
