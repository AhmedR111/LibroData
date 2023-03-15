package com.tema1.service;

import com.tema1.*;
import com.tema1.data.*;
import com.tema1.dto.*;
import com.tema1.exceptions.InexistingRetailerException;
import com.tema1.exceptions.NegativeIdException;

import java.util.*;
import java.util.stream.Collectors;

public class LinkAllService {

    //  maps of ids and specific instances, used to traverse the data in a quick n-case complexity manner
    private Map<Integer, PublishingBrand> brandsWithIds = null;
    private Map<Integer, PublishingRetailer> publishingRwithIds = null;
    private Map<Integer, Country> countriesWithIds = null;
    private Map<Integer, EditorialGroup> editorialGroupsWithIds = null;
    private Map<Integer, Book> booksWithIds = null;
    private Map<Integer, Author> authorsWithIds = null;
    private Map<Integer, Language> langsWithIds = null;

    public LinkAllService(){
        this.linkAll();
    }

    /**
     * Reads the specific files, with the help of the Data* classes
     * The data will be parsed and linked. This method needs to be called only once
     * (and done so in the constructor)
     */
    private void linkAll(){

        DataBook dataBook = new DataBook();
        DataAuthor dataAuthor = new DataAuthor();
        DataBookAuthor dataBookAuthor = new DataBookAuthor();

        DataEditorialGroup dataEditorialGroup = new DataEditorialGroup();
        DataEditorialGroupBook dataEditorialGroupBook = new DataEditorialGroupBook();
        DataPublishingBrandBook dataPublishingBrandBook = new DataPublishingBrandBook();
        DataPublishingRetailer dataPublishingRetailer = new DataPublishingRetailer();
        DataPublishingRetailerEditorialGroup dataPREG = new DataPublishingRetailerEditorialGroup();
        DataCountry dataCountry = new DataCountry();
        DataPublishingRetailerCountry dataPublishingRetailerCountry = new DataPublishingRetailerCountry();
        DataPublishingRetailer dataPR = new DataPublishingRetailer();
        DataPublishingBrand dataPublishingBrand = new DataPublishingBrand();
        DataPublishingRetailerPublishingBrandLINK dataPublishingRetailerPublishingBrandLINK = new DataPublishingRetailerPublishingBrandLINK();
        DataPublishingRetailerBook dataPublishingRetailerBook = new DataPublishingRetailerBook();
        DataLanguages dataLanguages = new DataLanguages();

        brandsWithIds = dataPublishingBrand.findAllWithIds();
        publishingRwithIds = dataPublishingRetailer.findAllWithIds();
        countriesWithIds = dataCountry.findAllWithIds();
        editorialGroupsWithIds = dataEditorialGroup.findAllWithIds();
        booksWithIds = dataBook.findAllWithIds();
        authorsWithIds = dataAuthor.findAllWithIds();
        langsWithIds = dataLanguages.findAllWithIds();

        List<EditorialGroupBook> egbList = dataEditorialGroupBook.findAll();
        List<PublishingRetailerPublishingBrand> links = dataPublishingRetailerPublishingBrandLINK.findAll();
        List<PublishingBrandBook> pbBookList = dataPublishingBrandBook.findAll();
        List<BookAuthor> bookAuthorList = dataBookAuthor.findAll();
        List<PublishingRetailerEditorialGroup> publishingRetailerEditorialGroupList = dataPREG.findAll();
        List<PublishingRetailerCountry> publishingRetailerCountryList = dataPublishingRetailerCountry.findAll();
        List<PublishingRetailerBook> prBookList = dataPublishingRetailerBook.findAll();


        for(BookAuthor ba : bookAuthorList){
            Book book = booksWithIds.get(ba.getBookId());
            Author author = authorsWithIds.get(ba.getAuthorId());
            book.getAuthors().add(author);
        }

        for(Map.Entry<Integer, Book> entry : booksWithIds.entrySet()){
            Book book = entry.getValue();
            Language lang = langsWithIds.get(book.getLanguageID());
            book.setLanguage(lang);
        }

        for(EditorialGroupBook ed : egbList){
            Book book = booksWithIds.get(ed.getBookId());
            EditorialGroup editorialGroup = editorialGroupsWithIds.get(ed.getGroupId());
            editorialGroup.getBook().add(book);

        }


        for(PublishingBrandBook prb : pbBookList){
            PublishingBrand pr = brandsWithIds.get(prb.getPublishingBrandId());
            Book book = booksWithIds.get(prb.getBookID());
            pr.getBook().add(book);
        }


        for(PublishingRetailerBook prb : prBookList){
            PublishingRetailer pr = publishingRwithIds.get(prb.getPublishingRetailerID());
            Book book = booksWithIds.get(prb.getBookID());
            pr.getPublishingArtifacts().add(book);
        }



        for (PublishingRetailerCountry prc : publishingRetailerCountryList){
            PublishingRetailer publishingRetailer = publishingRwithIds.get(prc.getPublishingRetailerID());
            Country country = countriesWithIds.get(prc.getCountryID());
            publishingRetailer.getCountries().add(country);
        }


        for(PublishingRetailerEditorialGroup preg : publishingRetailerEditorialGroupList){
            PublishingRetailer pr = publishingRwithIds.get(preg.getPrID());
            EditorialGroup eg = editorialGroupsWithIds.get(preg.getEgID());
            pr.getPublishingArtifacts().add(eg);
        }

        for(PublishingRetailerPublishingBrand link : links){
            PublishingRetailer publishingRetailer = publishingRwithIds.get(link.getRetailerId());
            PublishingBrand publishingBrand = brandsWithIds.get(link.getPublisherId());
            publishingRetailer.getPublishingArtifacts().add(publishingBrand);
        }



    }

    /**
     * Get the books associated with a retailer,
     * previous maps will be used in order to navigate to the object of interest
     * @param id
     * @return
     */
    public List<IPublishingArtifact> getBooksForPublishingRetailerId(int id){
        List<IPublishingArtifact> theBooks = new ArrayList<>();
        PublishingRetailer theRetailer = this.publishingRwithIds.get(id);
        if(theRetailer != null) {

            theBooks = theRetailer.getPublishingArtifacts();

        }

        // editorial groups and books
        List<EditorialGroup> editorialGroupList = new ArrayList<>();
        List<PublishingBrand> publishingBrands = new ArrayList<>();

        for(IPublishingArtifact publishingArtifact : theRetailer.getPublishingArtifacts()){
            if(publishingArtifact.getType().equals(PublishingArtifactType.EDITORIAL_GROUP)){
                editorialGroupList.add((EditorialGroup) publishingArtifact);
            }
            if(publishingArtifact.getType().equals(PublishingArtifactType.BRAND)){
                publishingBrands.add((PublishingBrand) publishingArtifact);
            }
        }
        for(EditorialGroup eg : editorialGroupList){
            theBooks.addAll(eg.getBook());
        }

        // brand and books

        for(PublishingBrand pb : publishingBrands){
            theBooks.addAll(pb.getBook());
        }


        theBooks = theBooks.stream().filter(x -> x.getType().equals(PublishingArtifactType.BOOK)).collect(Collectors.toList());
        return theBooks;
    }


    /**
     * Get the countries for a specific Book instance,
     * previous maps will be used in order to navigate to the object of interest
     * @param bookId
     * @return
     */
    public List<Country> getCountriesForBookID(int bookId){
        Book theBook = this.booksWithIds.get(bookId);
//        Map<Integer, PublishingRetailer>
        List<PublishingRetailer> allPublishingRetailers = new ArrayList<>();
        for(Map.Entry<Integer, PublishingRetailer> idAndRetailer :  this.publishingRwithIds.entrySet()){
//            System.out.println("RETAILER GROUP: " + idAndRetailer.getValue());
            allPublishingRetailers.add(idAndRetailer.getValue());
        }
        List<PublishingRetailer> retailersWhichSellTheBook = allPublishingRetailers.stream().filter(x -> x.getPublishingArtifacts().contains(theBook)).collect(Collectors.toList());
        Set<Country> countriesForBookSet = new HashSet<>();
        for(PublishingRetailer retailerWhichHasBook : retailersWhichSellTheBook){
            countriesForBookSet.addAll(retailerWhichHasBook.getCountries());
        }
        List<Country> countries  = new ArrayList<>();
        countries.addAll(countriesForBookSet);


        return countries;
    }


    /**
     * Get the common books (IPublishingArtifact instances) associated with two retailers
     * The method uses a Set instance in order to remove duplicates,
     * calls <code>getBooksForPublishingRetailerId</code> for each retailer
     * previous maps will be used in order to navigate to the object of interest
     * @param retailerID1
     * @param retailerID2
     * @return
     */
    public List<IPublishingArtifact> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){
        List<IPublishingArtifact> cartiR1 = getBooksForPublishingRetailerId(retailerID1);
        List<IPublishingArtifact> cartiR2 = getBooksForPublishingRetailerId(retailerID2);
        List<IPublishingArtifact> resultList = new ArrayList<>();

        Set<IPublishingArtifact> result = cartiR1.stream()
                .distinct()
                .filter(cartiR2::contains)
                .collect(Collectors.toSet());
        resultList.addAll(result);
        return resultList;
    }

    /**
     * Get the books for two specific retailers
     * @param retailerID1 - first retailer
     * @param retailerID2 - second retailer
     * @return
     */
    public List<IPublishingArtifact> getAllBooksForRetailerIDs(int retailerID1, int retailerID2){
        List<IPublishingArtifact> cartiR1 = getBooksForPublishingRetailerId(retailerID1);
        List<IPublishingArtifact> cartiR2 = getBooksForPublishingRetailerId(retailerID2);
        List<IPublishingArtifact> resultList = new ArrayList<>();

        Set<IPublishingArtifact> result = new HashSet<IPublishingArtifact>();
        result.addAll(cartiR1);
        result.addAll(cartiR2);

        resultList.addAll(result);

        return resultList;

    }
    /**
     * Get the languages for a specific publishing retailer
     * A Set instance will be used in order to remove duplicates
     * @param retailerID - id of the retailer
     * @return
     */
    public List<Language> getLanguagesForPublishingRetailerID(int retailerID){

        if(retailerID < 0){
            throw new NegativeIdException();
        }

        PublishingRetailer retailer = this.publishingRwithIds.get(retailerID);
        if(retailer == null){
            throw new InexistingRetailerException();
        }
        List<IPublishingArtifact> books = getBooksForPublishingRetailerId(retailerID);
        List<Language> languages = books.stream().map(x -> ((Book)x).getLanguage()).collect(Collectors.toList());
        Set<Language> languageSet = new HashSet<>();
        languageSet.addAll(languages);
        List<Language> languageList = new ArrayList<>();
        languageList.addAll(languageSet);
        return languageList;
    }


    /**
     * Helper accessor method
     * @return
     */
    public Map<Integer, PublishingBrand> getBrandsWithIds() {
        return brandsWithIds;
    }

    /**
     * Helper accessor method
     * @return
     */
    public Map<Integer, EditorialGroup> getEditorialGroupsWithIds() {
        return editorialGroupsWithIds;
    }
}
