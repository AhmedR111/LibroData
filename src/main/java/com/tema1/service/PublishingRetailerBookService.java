package com.tema1.service;

import com.tema1.Book;
import com.tema1.PublishingRetailer;
import com.tema1.data.DataBook;
import com.tema1.data.DataPublishingBrand;
import com.tema1.data.DataPublishingRetailer;
import com.tema1.data.DataPublishingRetailerBook;
import com.tema1.dto.PublishingRetailerBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PublishingRetailerBookService {
    public static List<PublishingRetailer> findPRWithBooks(){
        DataPublishingRetailer dataPR = new DataPublishingRetailer();
        DataBook dataBook = new DataBook();
        DataPublishingRetailerBook dataPublishingRetailerBook = new DataPublishingRetailerBook();
        Map<Integer, PublishingRetailer> prWithIDs = dataPR.findAllWithIds();
        Map<Integer, Book> booksWithIDs = dataBook.findAllWithIds();
        List<PublishingRetailerBook> prBookList = dataPublishingRetailerBook.findAll();
        for(PublishingRetailerBook prb : prBookList){
            PublishingRetailer pr = prWithIDs.get(prb.getPublishingRetailerID());
            Book book = booksWithIDs.get(prb.getBookID());
            pr.getPublishingArtifacts().add(book);
        }
        List<PublishingRetailer> publishingRetailersWithBooks = new ArrayList<>();
        for(Map.Entry<Integer,PublishingRetailer> idAndPR : prWithIDs.entrySet()){
            PublishingRetailer pr = idAndPR.getValue();
            publishingRetailersWithBooks.add(pr);
        }
        return publishingRetailersWithBooks;
    }
}
