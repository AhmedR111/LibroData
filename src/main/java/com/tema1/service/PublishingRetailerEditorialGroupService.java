package com.tema1.service;

import com.tema1.EditorialGroup;
import com.tema1.PublishingRetailer;
import com.tema1.data.DataEditorialGroup;
import com.tema1.data.DataPublishingRetailer;
import com.tema1.data.DataPublishingRetailerEditorialGroup;
import com.tema1.dto.PublishingRetailerEditorialGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PublishingRetailerEditorialGroupService {

    public static List<PublishingRetailer> findPublishingRetailersWithEG(){
        DataPublishingRetailer dataPublishingRetailer = new DataPublishingRetailer();
        DataEditorialGroup dataEditorialGroup = new DataEditorialGroup();
        DataPublishingRetailerEditorialGroup dataPREG = new DataPublishingRetailerEditorialGroup();
        Map<Integer,PublishingRetailer> publishingRetailerWithIDs = dataPublishingRetailer.findAllWithIds();
        Map<Integer, EditorialGroup> editorialGroupsWithIDs = dataEditorialGroup.findAllWithIds();
        List<PublishingRetailerEditorialGroup> publishingRetailerEditorialGroupList = dataPREG.findAll();
        for(PublishingRetailerEditorialGroup preg : publishingRetailerEditorialGroupList){
            PublishingRetailer pr = publishingRetailerWithIDs.get(preg.getPrID());
            EditorialGroup eg = editorialGroupsWithIDs.get(preg.getEgID());
            pr.getPublishingArtifacts().add(eg);
        }
        List<PublishingRetailer> prWithEG = new ArrayList<>();
        for(Map.Entry<Integer,PublishingRetailer> idAndPR : publishingRetailerWithIDs.entrySet()){
            PublishingRetailer pr = idAndPR.getValue();
            prWithEG.add(pr);
        }
        return prWithEG;
    }
}
