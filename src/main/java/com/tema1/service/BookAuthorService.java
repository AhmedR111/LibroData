package com.tema1.service;

import com.tema1.Author;
import com.tema1.Book;
import com.tema1.data.DataAuthor;
import com.tema1.data.DataBook;
import com.tema1.data.DataBookAuthor;
import com.tema1.dto.BookAuthor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookAuthorService {

//    public static void populateAuthors(List<Book> books){
//
//    }
    public static List<Book> findBooksWithAuthors(){
        DataBook dataBook = new DataBook();
        DataAuthor dataAuthor = new DataAuthor();
        DataBookAuthor dataBookAuthor = new DataBookAuthor();
        Map<Integer, Book> booksWithIds = dataBook.findAllWithIds();
        Map<Integer, Author> authorsWithIds = dataAuthor.findAllWithIds();
        List<BookAuthor> bookAuthorList = dataBookAuthor.findAll();
        for(BookAuthor ba : bookAuthorList){
            Book book = booksWithIds.get(ba.getBookId());
            Author author = authorsWithIds.get(ba.getAuthorId());
            book.getAuthors().add(author);
        }
        List<Book> booksWithAuthors = new ArrayList<>();
        for(Map.Entry<Integer, Book> idAndBook : booksWithIds.entrySet()){
            Book book = idAndBook.getValue();
            booksWithAuthors.add(book);
        }

        return booksWithAuthors;
    }

}
