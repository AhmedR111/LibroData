package com.tema1.teste;

import com.tema1.Language;

import java.util.List;

public class GetLanguageRetailerIdTest extends AbstractTest{
    @Override
    public void rulare() {
        //5 teste pentru getLanguagesForRetailerIDs()

        System.out.println("\n==================Retailer 17==================\n");
        List<Language> lang1 = linkAllService.getLanguagesForPublishingRetailerID( 17);
            for (Language l : lang1) {
                System.out.println(l);
            }

        System.out.println("\n==================Retailer 22==================\n");
        List<Language> lang2 = linkAllService.getLanguagesForPublishingRetailerID( 22);
            for (Language l : lang1) {
                System.out.println(l);
            }

        System.out.println("\n==================Retailer 29==================\n");
        List<Language> lang3 = linkAllService.getLanguagesForPublishingRetailerID( 29);
            for (Language l : lang1) {
                System.out.println(l);
            }

        System.out.println("\n==================Retailer 33==================\n");
        List<Language> lang4 = linkAllService.getLanguagesForPublishingRetailerID( 33);
            for (Language l : lang1) {
                System.out.println(l);
            }

        System.out.println("\n==================Retailer 14==================\n");
        List<Language> lang5 = linkAllService.getLanguagesForPublishingRetailerID( 14);
            for (Language l : lang1) {
                System.out.println(l);
            }
    }
}
