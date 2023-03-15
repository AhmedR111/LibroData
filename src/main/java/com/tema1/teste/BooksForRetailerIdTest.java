package com.tema1.teste;

import com.tema1.IPublishingArtifact;
import com.tema1.service.LinkAllService;

import java.util.List;

public class BooksForRetailerIdTest  extends  AbstractTest{
    @Override
    public void rulare() {
        //        //5 teste pentru getAllBooksForRetailerIDs()
//

        System.out.println("\n==================Retailerii 3 si 7==================\n");
        List<IPublishingArtifact> toateCartiile1 = linkAllService.getAllBooksForRetailerIDs(3, 7);
            for (IPublishingArtifact book : toateCartiile1) {
                System.out.println(book);
            }

        System.out.println("\n==================Retailerii 5 si 9==================\n");
        List<IPublishingArtifact> toateCartiile2 = linkAllService.getAllBooksForRetailerIDs(5, 9);
        for (IPublishingArtifact book : toateCartiile2) {
            System.out.println(book);
        }

        System.out.println("\n==================Retailerii 8 si 12==================\n");
        List<IPublishingArtifact> toateCartiile3 = linkAllService.getAllBooksForRetailerIDs(8, 12);
        for (IPublishingArtifact book : toateCartiile3) {
            System.out.println(book);
        }

        System.out.println("\n==================Retailerii 10 si 16==================\n");
        List<IPublishingArtifact> toateCartiile4 = linkAllService.getAllBooksForRetailerIDs(10, 16);
        for (IPublishingArtifact book : toateCartiile4) {
            System.out.println(book);
        }

        System.out.println("\n==================Retailerii 12 si 19==================\n");
        List<IPublishingArtifact> toateCartiile5 = linkAllService.getAllBooksForRetailerIDs(12, 19);
        for (IPublishingArtifact book : toateCartiile5) {
            System.out.println(book);
        }

    }
}
