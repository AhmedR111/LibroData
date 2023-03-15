package com.tema1.data;

import com.tema1.Author;

public class DataAuthor extends GenericData<Author> {


    public DataAuthor() {
        super("authors.in");
    }

    @Override
    protected Author transformare(String linieDinFisier) {
        Author author = new Author();
        String[] tokens = linieDinFisier.split("###");
        author.setId(Integer.valueOf(tokens[0]));
        author.setFirstName(tokens[1]);
        author.setLastName(tokens[2]);
        return author;
    }
}
