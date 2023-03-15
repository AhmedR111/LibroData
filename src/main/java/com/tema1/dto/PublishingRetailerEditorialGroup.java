package com.tema1.dto;

import com.tema1.data.IEntitateFisier;

public class PublishingRetailerEditorialGroup implements IEntitateFisier {
    private Integer prID;
    private Integer egID;

    public PublishingRetailerEditorialGroup(Integer prID, Integer egID) {
        this.prID = prID;
        this.egID = egID;
    }

    public PublishingRetailerEditorialGroup() {
    }

    public Integer getPrID() {
        return prID;
    }

    public void setPrID(Integer prID) {
        this.prID = prID;
    }

    public Integer getEgID() {
        return egID;
    }

    public void setEgID(Integer egID) {
        this.egID = egID;
    }

    @Override
    public Integer getId() {
        return null;
    }
}
