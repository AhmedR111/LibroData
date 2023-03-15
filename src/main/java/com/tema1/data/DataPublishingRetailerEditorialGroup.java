package com.tema1.data;

import com.tema1.dto.PublishingRetailerBook;
import com.tema1.dto.PublishingRetailerEditorialGroup;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataPublishingRetailerEditorialGroup extends GenericData<PublishingRetailerEditorialGroup>{
    public DataPublishingRetailerEditorialGroup() {
        super("publishing-retailers-editorial-groups.in");
    }

    @Override
    protected PublishingRetailerEditorialGroup transformare(String linieDinFisier) {
        PublishingRetailerEditorialGroup preg = new PublishingRetailerEditorialGroup();
        String[] tokens = linieDinFisier.split("###");
        preg.setPrID(Integer.valueOf(tokens[0]));
        preg.setEgID(Integer.valueOf(tokens[1]));
        return preg;
    }



    @Override
    public Map<Integer, PublishingRetailerEditorialGroup> findAllWithIds() {
        throw new UnsupportedOperationException();
    }
}
