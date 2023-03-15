package com.tema1;

import com.tema1.data.IEntitateFisier;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "book")
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements IPublishingArtifact, IEntitateFisier {


    @XmlTransient
    private Integer id;
    @XmlElement(name = "title")
    private String name;
    private String subtitle;
    private String isbn;
    private int pageCount;
    private String keywords;
    private int languageID;
    private Date createdOn;
    @XmlTransient
    private Language language;

    List<Author> authors = new ArrayList<>();

    public Book(Integer id, String name, String subtitle,String isbn ,int pageCount, String kewwords, int languageID, Date createdOn) {
        this.id = id;
        this.name = name;
        this.subtitle = subtitle;
        this.isbn=isbn;
        this.pageCount = pageCount;
        this.keywords = kewwords;
        this.languageID = languageID;
        this.createdOn=createdOn;
    }

    public Book() {

    }

    @Override
    public String publish() {
        String result = null;
        try{
            JAXBContext contextObj = JAXBContext.newInstance(Book.class);

            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshallerObj.marshal(this, baos);

            result  = new String(baos.toByteArray());
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public PublishingArtifactType getType() {
        return PublishingArtifactType.BOOK;

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pageCount=" + pageCount +
                ", keywords='" + keywords + '\'' +
                ", languageID=" + languageID +
                ", createdOn=" + createdOn +
                ", language=" + language +
                ", authors=" + authors +
                '}';
    }
}
