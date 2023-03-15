package com.tema1.data;

import com.tema1.Language;

public class DataLanguages extends GenericData<Language>{

    public DataLanguages() {
        super("languages.in");
    }

    @Override
    protected Language transformare(String linieDinFisier) {
        Language languages = new Language();
        String[] tokens = linieDinFisier.split("###");
        languages.setId(Integer.valueOf(tokens[0]));
        languages.setCode(tokens[1]);
        languages.setName(tokens[2]);
        return languages;
    }
}
