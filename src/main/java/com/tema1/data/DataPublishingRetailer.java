package com.tema1.data;

import com.tema1.PublishingRetailer;

public class DataPublishingRetailer extends GenericData<PublishingRetailer>{

    public DataPublishingRetailer() {
        super("publishing-retailers.in");
    }

    @Override
    protected PublishingRetailer transformare(String linieDinFisier) {
        PublishingRetailer publishingRetailers = new PublishingRetailer();
        String[] tokens = linieDinFisier.split("###");
        publishingRetailers.setId(Integer.valueOf(tokens[0]));
        publishingRetailers.setName(tokens[1]);
        return publishingRetailers;
    }
}
