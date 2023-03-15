package com.tema1.data;

import com.tema1.PublishingBrand;

public class DataPublishingBrand extends GenericData<PublishingBrand> {

    public DataPublishingBrand() {
        super("publishing-brands.in");
    }

    @Override
    protected PublishingBrand transformare(String linieDinFisier) {
        PublishingBrand publishingBrand = new PublishingBrand();
        String[] tokens = linieDinFisier.split("###");
        publishingBrand.setId(Integer.valueOf(tokens[0]));
        publishingBrand.setName(tokens[1]);
        return publishingBrand;
    }
}
