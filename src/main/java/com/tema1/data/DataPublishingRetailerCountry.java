package com.tema1.data;

import com.tema1.dto.PublishingRetailerCountry;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataPublishingRetailerCountry extends GenericData<PublishingRetailerCountry>{

    public DataPublishingRetailerCountry() {
        super("publishing-retailers-countries.in");
    }

    @Override
    protected PublishingRetailerCountry transformare(String linieDinFisier) {
        PublishingRetailerCountry prc = new PublishingRetailerCountry();
        String[] tokens = linieDinFisier.split("###");
        prc.setPublishingRetailerID(Integer.valueOf(tokens[0]));
        prc.setCountryID(Integer.valueOf(tokens[1]));
        return prc;
    }



    @Override
    public Map<Integer, PublishingRetailerCountry> findAllWithIds() {
        throw new UnsupportedOperationException();
    }
}
