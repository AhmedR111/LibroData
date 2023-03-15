package com.tema1.data;

import com.tema1.Country;
import com.tema1.util.IConstants;

public class DataCountry extends GenericData<Country>{


    public DataCountry() {
        super("countries.in");
    }

    @Override
    protected Country transformare(String linieDinFisier) {
        Country countries = new Country();
        String[] tokens = linieDinFisier.split("###");
        countries.setId(Integer.valueOf(tokens[0]));
        countries.setCountryCode(tokens[1]);
        return countries;
    }
}
