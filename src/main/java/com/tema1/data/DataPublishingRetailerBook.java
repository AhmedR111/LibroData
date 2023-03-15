package com.tema1.data;

import com.tema1.dto.PublishingRetailerBook;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataPublishingRetailerBook extends GenericData<PublishingRetailerBook> {
    public DataPublishingRetailerBook() {
        super("publishing-retailers-books.in");
    }

    @Override
    protected PublishingRetailerBook transformare(String linieDinFisier) {
        PublishingRetailerBook prb = new PublishingRetailerBook();
        String[] tokens = linieDinFisier.split("###");
        prb.setPublishingRetailerID(Integer.valueOf(tokens[0]));
        prb.setBookID(Integer.valueOf(tokens[1]));
        return prb;
    }

    @Override
    public Map<Integer, PublishingRetailerBook> findAllWithIds() {
        throw new UnsupportedOperationException();
    }
}
