package com.tema1.data;

import com.tema1.Book;
import com.tema1.dto.PublishingRetailerPublishingBrand;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataPublishingRetailerPublishingBrandLINK extends GenericData<PublishingRetailerPublishingBrand> {
    public DataPublishingRetailerPublishingBrandLINK() {
        super("publishing-retailers-publishing-brands.in");

    }

    @Override
    protected PublishingRetailerPublishingBrand transformare(String linieDinFisier) {
        PublishingRetailerPublishingBrand dto = new PublishingRetailerPublishingBrand();
        String[] tokens = linieDinFisier.split("###");
        dto.setRetailerId(Integer.valueOf(tokens[0]));
        dto.setPublisherId(Integer.valueOf(tokens[1]));
//    RetailerId###PublisherId
        return dto;
    }


}
