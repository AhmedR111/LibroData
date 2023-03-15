package com.tema1.dto;

import com.tema1.data.IEntitateFisier;

public class PublishingRetailerPublishingBrand implements IEntitateFisier {
//    RetailerId###PublisherId
//31###11
    private Integer retailerId;
    private Integer publisherId;

    public PublishingRetailerPublishingBrand() {
    }

    public PublishingRetailerPublishingBrand(Integer retailerId, Integer publisherId) {
        this.retailerId = retailerId;
        this.publisherId = publisherId;
    }

    public Integer getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Integer retailerId) {
        this.retailerId = retailerId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public String toString() {
        return "PublishingRetailerPublishingBrand{" +
                "retailerId=" + retailerId +
                ", publisherId=" + publisherId +
                '}';
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException();
    }
}
