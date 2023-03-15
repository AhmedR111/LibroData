package com.tema1.data;

import com.tema1.EditorialGroup;

public class DataEditorialGroup extends GenericData<EditorialGroup> {

    public DataEditorialGroup() {
        super("editorial-groups.in");
    }

    @Override
    protected EditorialGroup transformare(String linieDinFisier) {
        EditorialGroup editorialGroup = new EditorialGroup();
        String[] tokens = linieDinFisier.split("###");
        editorialGroup.setId(Integer.valueOf(tokens[0]));
        editorialGroup.setName(tokens[1]);
        return editorialGroup;
    }
}
