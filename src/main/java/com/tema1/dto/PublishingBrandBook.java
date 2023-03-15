package com.tema1.dto;

import com.tema1.data.IEntitateFisier;

public class PublishingBrandBook implements IEntitateFisier {
    private Integer publishingBrandId;
    private Integer bookID;

    public PublishingBrandBook(Integer publishingRetailerID, Integer bookID) {
        this.publishingBrandId = publishingRetailerID;
        this.bookID = bookID;
    }

    public PublishingBrandBook() {
    }

    public Integer getPublishingBrandId() {
        return publishingBrandId;
    }

    public void setPublishingBrandId(Integer publishingBrandId) {
        this.publishingBrandId = publishingBrandId;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getId(){
        return this.getBookID();
    }

    @Override
    public String toString() {
        return "PublishingBrandBook{" +
                "publishingBrandId=" + publishingBrandId +
                ", bookID=" + bookID +
                '}';
    }
}
