package com.tema1.data;

import com.tema1.dto.PublishingBrandBook;
import com.tema1.dto.PublishingRetailerBook;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataPublishingBrandBook extends GenericData<PublishingBrandBook> {
    public DataPublishingBrandBook() {
        super("publishing-brands-books.in");
    }
//    @Override
//    public List<PublishingBrandBook> findAll() {
//        List<PublishingBrandBook> publishingBrandBookList= new ArrayList<>();
//        try {
//            List<String> prBookString = Files.readAllLines(Paths.get
//                    ("publishing-brands-books.in"), StandardCharsets.UTF_8);
//            prBookString.remove(0);
//            for(String line: prBookString){
//                PublishingBrandBook pbb = new PublishingBrandBook();
//                String[] tokens = line.split("###");
//                // PublisherId###BookId
//                pbb.setPublishingBrandId(Integer.valueOf(tokens[0]));
//                pbb.setBookID(Integer.valueOf(tokens[1]));
//                publishingBrandBookList.add(pbb);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return publishingBrandBookList;
//    }

    @Override
    protected PublishingBrandBook transformare(String linieDinFisier) {

        PublishingBrandBook pbb = new PublishingBrandBook();
                String[] tokens = linieDinFisier.split("###");
                // PublisherId###BookId
                pbb.setPublishingBrandId(Integer.valueOf(tokens[0]));
                pbb.setBookID(Integer.valueOf(tokens[1]));
        return pbb;
    }

    @Override
    public Map<Integer, PublishingBrandBook> findAllWithIds() {
        throw new UnsupportedOperationException();
    }
}
