package com.tema1.service;

import com.tema1.EditorialGroup;
import com.tema1.PublishingBrand;
import com.tema1.PublishingRetailer;
import com.tema1.data.DataPublishingBrand;
import com.tema1.data.DataPublishingRetailer;
import com.tema1.data.DataPublishingRetailerPublishingBrandLINK;
import com.tema1.dto.PublishingRetailerPublishingBrand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PublishingRetailerPublishingBrandService {

    public static List<PublishingRetailer> findPublishingRetailerWithPublishingBrands(){

        DataPublishingRetailer dataPublishingRetailer = new DataPublishingRetailer();
        DataPublishingBrand dataPublishingBrand = new DataPublishingBrand();
        DataPublishingRetailerPublishingBrandLINK dataPublishingRetailerPublishingBrandLINK = new DataPublishingRetailerPublishingBrandLINK();


        List<PublishingRetailerPublishingBrand> links = dataPublishingRetailerPublishingBrandLINK.findAll();
        Map<Integer, PublishingRetailer> retailersWithIds = dataPublishingRetailer.findAllWithIds();
        Map<Integer, PublishingBrand> brandsWithIds = dataPublishingBrand.findAllWithIds();

        for(PublishingRetailerPublishingBrand link : links){
            PublishingRetailer publishingRetailer = retailersWithIds.get(link.getRetailerId());
            PublishingBrand publishingBrand = brandsWithIds.get(link.getPublisherId());
            publishingRetailer.getPublishingArtifacts().add(publishingBrand);
        }

        List<PublishingRetailer> result = new ArrayList<>();
        for(Map.Entry<Integer, PublishingRetailer> idMapElement : retailersWithIds.entrySet()){

            result.add(idMapElement.getValue());
        }

        return result;
    }

}
