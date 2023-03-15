package com.tema1.data;

import com.tema1.Book;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBook extends GenericData<Book>{

    public DataBook() {
        super("books.in");

    }

    @Override
    protected Book transformare(String linieDinFisier) {
        Book book = new Book();
        String[] tokens = linieDinFisier.split("###");
        // ID###Name###Subtitle###ISBN###PageCount###Keywords###LanguageId###CreatedOn
        book.setId(Integer.valueOf(tokens[0]));
        book.setName(tokens[1]);
        book.setSubtitle(tokens[2]);
        book.setIsbn(tokens[3]);

        book.setPageCount(Integer.valueOf(tokens[4]));
        book.setKeywords(tokens[5]);
        book.setLanguageID(Integer.valueOf(tokens[6]));

        // 11.11.2016 10:11:05
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            Date data = simpleDateFormat.parse(tokens[7]);
            book.setCreatedOn(data);
        }catch(Exception e){
            e.printStackTrace();
        }

        return book;
    }



}
