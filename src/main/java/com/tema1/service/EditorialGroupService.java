package com.tema1.service;

import com.tema1.Book;
import com.tema1.EditorialGroup;
import com.tema1.data.DataBook;
import com.tema1.data.DataEditorialGroup;
import com.tema1.data.DataEditorialGroupBook;
import com.tema1.dto.EditorialGroupBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EditorialGroupService {

    public static List<EditorialGroup> findEditorialGroupsWithBooks() {
        DataBook dataBook = new DataBook();
        DataEditorialGroup dataEditorialGroup = new DataEditorialGroup();
        DataEditorialGroupBook dataEditorialGroupBook = new DataEditorialGroupBook();

        Map<Integer, Book> booksWithIds = dataBook.findAllWithIds();
        Map<Integer, EditorialGroup> editorialGroupsWithIds = dataEditorialGroup.findAllWithIds();
        List<EditorialGroupBook> egbList = dataEditorialGroupBook.findAll();

        for(EditorialGroupBook ed : egbList){
            Book book = booksWithIds.get(ed.getBookId());
            EditorialGroup editorialGroup = editorialGroupsWithIds.get(ed.getGroupId());
            editorialGroup.getBook().add(book);

        }
        List<EditorialGroup> result = new ArrayList<>();
        for(Map.Entry<Integer, EditorialGroup> idAndEditorialGroup : editorialGroupsWithIds.entrySet()){

            result.add(idAndEditorialGroup.getValue());
        }
        return result;

    }

}
