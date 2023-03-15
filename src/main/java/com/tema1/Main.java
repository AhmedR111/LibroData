package com.tema1;

import com.tema1.service.*;
import com.tema1.teste.*;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {



    public static void main(String[] args) {
        //write your code here;

        LinkAllService linkAllService = new LinkAllService();

        //5 teste pentru getBooksForPublishingRetailerID()
        ITest testBooksForPublishingRetailerIdTest = new GetBooksForPublishingRetailerIdTest();
        testBooksForPublishingRetailerIdTest.rulare();


        // TEST XML
        System.out.println("=====================TEST XML BOOK=====================");
        List<IPublishingArtifact> booksForARetailer1 = linkAllService.getBooksForPublishingRetailerId(2);
        Book btest = (Book)booksForARetailer1.get(0);

        System.out.println(btest.publish());

        System.out.println("=====================TEST XML PUBLISHINGBRAND=====================");
        Map<Integer, PublishingBrand> brands = linkAllService.getBrandsWithIds();
        PublishingBrand b = brands.get(11);
        System.out.println(b.publish());

        System.out.println("=====================TEST XML EDITORIALGROUP=====================");
        Map<Integer, EditorialGroup> edGroups = linkAllService.getEditorialGroupsWithIds();
        EditorialGroup ed1 = edGroups.get(17);
        System.out.println(ed1.publish());
        // TEST XML

        //5 teste pentru getCountriesForBookID()
        ITest testGetCountries = new CountriesBookIdTest();
        testGetCountries.rulare();
        //5 teste pentru getAllBooksForRetailerIDs()
        ITest testBookRetailerId = new BooksForRetailerIdTest();
        testBookRetailerId.rulare();


        //5 teste pentru getLanguagesForRetailerIDs()
        ITest testLanguageRetailerId = new GetLanguageRetailerIdTest();
        testLanguageRetailerId.rulare();

        //5 teste pentru getCommonBooksForRetailerIDs()
        ITest testCommonBooksForRetailerID = new CommonBooksForRetailerIDTest();
        testCommonBooksForRetailerID.rulare();


    }
}

