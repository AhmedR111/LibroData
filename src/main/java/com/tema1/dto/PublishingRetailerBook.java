package com.tema1.dto;

import com.tema1.data.IEntitateFisier;

public class PublishingRetailerBook implements IEntitateFisier {
    private Integer publishingRetailerID;
    private Integer bookID;

    public PublishingRetailerBook(Integer publishingRetailerID, Integer bookID) {
        this.publishingRetailerID = publishingRetailerID;
        this.bookID = bookID;
    }

    public PublishingRetailerBook() {
    }

    public Integer getPublishingRetailerID() {
        return publishingRetailerID;
    }

    public void setPublishingRetailerID(Integer publishingRetailerID) {
        this.publishingRetailerID = publishingRetailerID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    @Override
    public String toString() {
        return "PublishingRetailerBook{" +
                "publishingRetailerID=" + publishingRetailerID +
                ", bookID=" + bookID +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
