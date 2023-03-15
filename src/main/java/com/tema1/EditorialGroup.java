package com.tema1;

import com.tema1.data.IEntitateFisier;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class EditorialGroup implements IPublishingArtifact, IEntitateFisier {

    private Integer id;
    private String name;
    @XmlElementWrapper(name = "books")
    private List<Book> book = new ArrayList<>();

    public EditorialGroup(Integer id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.book = books;
    }

    public EditorialGroup() {
    }

    @Override
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

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String publish() {

        String result = null;
        try{
            JAXBContext contextObj = JAXBContext.newInstance(EditorialGroup.class);

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
        return PublishingArtifactType.EDITORIAL_GROUP;
    }

    @Override
    public String toString() {
        return "EditorialGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + book +
                '}';
    }


}
