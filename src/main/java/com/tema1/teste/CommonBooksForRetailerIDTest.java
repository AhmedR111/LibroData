package com.tema1.teste;

import com.tema1.IPublishingArtifact;

import java.util.List;

public class CommonBooksForRetailerIDTest extends AbstractTest {

    @Override
    public void rulare() {
        //5 teste pentru getCommonBooksForRetailerIDs()

        System.out.println("\n==================Retailerii 3 si 8==================\n");
        List<IPublishingArtifact> cartiComune1 = linkAllService.getAllBooksForRetailerIDs(3, 8);
        for (IPublishingArtifact book : cartiComune1) {
            System.out.println(book);
        }

        System.out.println("\n==================Retailerii 2 si 10==================\n");
        List<IPublishingArtifact> cartiComune2 = linkAllService.getAllBooksForRetailerIDs(2, 10);
        for (IPublishingArtifact book : cartiComune2) {
            System.out.println(book);
        }

        System.out.println("\n==================Retailerii 7 si 12==================\n");
        List<IPublishingArtifact> cartiComune3 = linkAllService.getAllBooksForRetailerIDs(7, 12);
        for (IPublishingArtifact book : cartiComune3) {
            System.out.println(book);
        }

        System.out.println("\n==================Retailerii 14 si 27==================\n");
        List<IPublishingArtifact> cartiComune4 = linkAllService.getAllBooksForRetailerIDs(14, 27);
        for (IPublishingArtifact book : cartiComune4) {
            System.out.println(book);
        }

        System.out.println("\n==================Retailerii 32 si 11==================\n");
        List<IPublishingArtifact> cartiComune5 = linkAllService.getAllBooksForRetailerIDs(32, 11);
        for (IPublishingArtifact book : cartiComune5) {
            System.out.println(book);
        }
    }
}
