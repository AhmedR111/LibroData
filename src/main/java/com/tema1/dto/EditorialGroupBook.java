package com.tema1.dto;

import com.tema1.EditorialGroup;
import com.tema1.data.IEntitateFisier;

public class EditorialGroupBook implements IEntitateFisier {
    // GroupId###BookId

    private Integer groupId;
    private Integer bookId;

    public EditorialGroupBook(){

    }

    public EditorialGroupBook(Integer groupId, Integer bookId) {
        this.groupId = groupId;
        this.bookId = bookId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException();
    }
}
