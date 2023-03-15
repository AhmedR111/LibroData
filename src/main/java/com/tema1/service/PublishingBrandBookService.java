package com.tema1.service;

import com.tema1.Book;
import com.tema1.PublishingBrand;
import com.tema1.data.*;
import com.tema1.dto.PublishingBrandBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PublishingBrandBookService {
    public static List<PublishingBrand> findPublishingBrandsWithBooks(){
        DataPublishingBrand dataPR = new DataPublishingBrand();
        DataBook dataBook = new DataBook();
        DataPublishingBrandBook dataPublishingRetailerBook = new DataPublishingBrandBook();
        Map<Integer, PublishingBrand> prWithIDs = dataPR.findAllWithIds();
        Map<Integer, Book> booksWithIDs = dataBook.findAllWithIds();
        List<PublishingBrandBook> prBookList = dataPublishingRetailerBook.findAll();
        for(PublishingBrandBook prb : prBookList){
            PublishingBrand pr = prWithIDs.get(prb.getPublishingBrandId());
            Book book = booksWithIDs.get(prb.getBookID());
            pr.getBook().add(book);
        }
        List<PublishingBrand> publishingRetailersWithBooks = new ArrayList<>();
        for(Map.Entry<Integer,PublishingBrand> idAndPR : prWithIDs.entrySet()){
            PublishingBrand pr = idAndPR.getValue();
            publishingRetailersWithBooks.add(pr);
        }
        return publishingRetailersWithBooks;
    }
}
