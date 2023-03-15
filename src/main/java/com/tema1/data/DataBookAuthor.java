package com.tema1.data;

import com.tema1.Book;
import com.tema1.dto.BookAuthor;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBookAuthor extends GenericData<BookAuthor>{


    public DataBookAuthor() {
        super("books-authors.in");
    }

    @Override
    protected BookAuthor transformare(String linieDinFisier) {
        BookAuthor ba = new BookAuthor();
        String[] tokens = linieDinFisier.split("###");
        ba.setBookId(Integer.valueOf(tokens[0]));
        ba.setAuthorId(Integer.valueOf(tokens[1]));
        return ba;
    }


    @Override
    public Map<Integer, BookAuthor> findAllWithIds() {
        throw new UnsupportedOperationException();
    }

}
