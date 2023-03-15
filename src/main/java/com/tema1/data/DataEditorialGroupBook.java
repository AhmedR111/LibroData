package com.tema1.data;

import com.tema1.EditorialGroup;
import com.tema1.dto.EditorialGroupBook;

public class DataEditorialGroupBook extends GenericData<EditorialGroupBook> {

    public DataEditorialGroupBook() {
        super("editorial-groups-books.in");
    }

    @Override
    protected EditorialGroupBook transformare(String linieDinFisier) {
        EditorialGroupBook editorialGroupBook = new EditorialGroupBook();
        String[] tokens = linieDinFisier.split("###");
        // GroupId###BookId
        editorialGroupBook.setGroupId(Integer.valueOf(tokens[0]));
        editorialGroupBook.setBookId(Integer.valueOf(tokens[1]));
        return editorialGroupBook;
    }
}
