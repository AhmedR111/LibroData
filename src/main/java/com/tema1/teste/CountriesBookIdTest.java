package com.tema1.teste;

import com.tema1.Country;
import com.tema1.service.LinkAllService;

import java.util.List;

public class CountriesBookIdTest extends  AbstractTest{

    @Override
    public void rulare() {
        //        //5 teste pentru getCountriesForBookID()

        System.out.println("\n==================Book ID 1124==================\n");
        List<Country> countries2 = linkAllService.getCountriesForBookID(1124);
        for(Country c : countries2){
            System.out.println(c);
        }

        System.out.println("\n==================Book ID 2922==================\n");
        List<Country> countries3 = linkAllService.getCountriesForBookID(2922);
        for(Country c : countries3){
            System.out.println(c);
        }

        System.out.println("\n==================Book ID 5279==================\n");
        List<Country> countries4 = linkAllService.getCountriesForBookID(5279);
        for(Country c : countries4){
            System.out.println(c);
        }

        System.out.println("\n==================Book ID 14749==================\n");
        List<Country> countries5 = linkAllService.getCountriesForBookID(14749);
        for(Country c : countries5){
            System.out.println(c);
        }

        System.out.println("\n==================Book ID 12609==================\n");
        List<Country> countries = linkAllService.getCountriesForBookID(12609);
        for(Country c : countries){
            System.out.println(c);
        }
    }
}
