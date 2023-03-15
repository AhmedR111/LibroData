package com.tema1;

import com.tema1.data.IEntitateFisier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PublishingRetailer implements IEntitateFisier {
    private Integer id;
    private String name;

    List<Country> countries = new ArrayList<>();
    List<IPublishingArtifact>  publishingArtifacts = new ArrayList<>();

    public PublishingRetailer(Integer id, String name, List<Country> countries) {
        this.id = id;
        this.name = name;
        this.countries = countries;
    }

    public PublishingRetailer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }



    public void setPublishingArtifacts(List<IPublishingArtifact> publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    @Override
    public String toString() {
        return "PublishingRetailer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countries=" + countries +
                ", publishingArtifacts=" + publishingArtifacts +
                '}';
    }
}
