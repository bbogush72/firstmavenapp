package com.cybertek.JavaPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionReview {
    public static void main(String[] args) {

        /*
         *          Representing table of data

                    //   Name , Age , gender
                    //   John   22      Male
                    //   Mary   25      Female
                    //   Adam   18      Male
         *
         *
         * */

        // The goal is represent this table in collection object
        // so we can access just in plain english
        // give me row number 3 and Gender column

        // represent each row as Map of String, String
        Map<String, String> firstRowMap = new HashMap<>();
        firstRowMap.put("Name", "John");
        firstRowMap.put("Age", "22");
        firstRowMap.put("Gender", "Male");
        System.out.println("firstRowMap : " + firstRowMap);
        System.out.println("first row Age column is " + firstRowMap.get("Age"));
        Map<String, String> secondRowMap = new HashMap<>();
        secondRowMap.put("Name", "Mary");
        secondRowMap.put("Age", "25");
        secondRowMap.put("Gender", "Female");
        System.out.println("secondRowMap : " + secondRowMap);
        System.out.println("second row Name column is " + secondRowMap.get("Name"));
        Map<String, String> thirdRowMap = new HashMap<>();
        thirdRowMap.put("Name", "Adam");
        thirdRowMap.put("Age", "18");
        thirdRowMap.put("Gender", "Male");
        System.out.println("thirdRowMap : " + thirdRowMap);
        System.out.println("third row Name column is " + thirdRowMap.get("Gender"));
        // Storing 3 Map object into another collection object
        // By default we will just use List since we dont have any restriction
        System.out.println("-------------------------");
        List<Map<String, String>> allRowMaps = new ArrayList<>();
        allRowMaps.add(firstRowMap);
        allRowMaps.add(secondRowMap);
        allRowMaps.add(thirdRowMap);
        System.out.println(allRowMaps);
        System.out.println("First row Gender colomn : " +
                allRowMaps.get(0).get("Gender"));
        System.out.println("Second row Age colomn : " +
                allRowMaps.get(1).get("Age"));
        System.out.println("Third row Name colomn :  " +
                allRowMaps.get(2).get("Name"));


    }
}
