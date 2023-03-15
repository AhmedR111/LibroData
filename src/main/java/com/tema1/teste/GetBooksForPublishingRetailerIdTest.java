package com.tema1.teste;

import com.tema1.IPublishingArtifact;

import java.util.List;

public class GetBooksForPublishingRetailerIdTest extends AbstractTest{


    @Override
    public void rulare() {
        //5 teste pentru getBooksForPublishingRetailerID()
        System.out.println("\n==================Retailer 2==================\n");
        List<IPublishingArtifact> booksForARetailer1 = linkAllService.getBooksForPublishingRetailerId(2);
        for(IPublishingArtifact book : booksForARetailer1){
            System.out.println(book);
        }

        System.out.println("\n==================Retailer 8==================\n");
        List<IPublishingArtifact> booksForARetailer2 = linkAllService.getBooksForPublishingRetailerId(8);
        for(IPublishingArtifact book : booksForARetailer2){
            System.out.println(book);
        }

        System.out.println("\n==================Retailer 11==================\n");
        List<IPublishingArtifact> booksForARetailer3 = linkAllService.getBooksForPublishingRetailerId(11);
        for(IPublishingArtifact book : booksForARetailer3){
            System.out.println(book);
        }

        System.out.println("\n==================Retailer 14==================\n");
        List<IPublishingArtifact> booksForARetailer4 = linkAllService.getBooksForPublishingRetailerId(14);
        for(IPublishingArtifact book : booksForARetailer4){
            System.out.println(book);
        }

        System.out.println("\n==================Retailer 17==================\n");
        List<IPublishingArtifact> booksForARetailer5 = linkAllService.getBooksForPublishingRetailerId(17);
        for(IPublishingArtifact book : booksForARetailer5){
            System.out.println(book);
        }
    }
}
