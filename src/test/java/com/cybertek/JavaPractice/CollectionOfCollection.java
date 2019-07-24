package com.cybertek.JavaPractice;

import java.util.*;

public class CollectionOfCollection {
    public static void main(String[] args) {

        // Representing table of data

        //   Name , Age
        //   John   22
        //   Mary   25
        //   Adam   18


        // storing all the names
        List<String> nameList = new ArrayList<>(Arrays.asList("john", "Mary", "Adam"));

        //  Arrays.asList("john","Mary","Adam" )  -->>  );
        // javca 9 feature below
        //List<String> nameList2 = new ArrayList<>(List.of("john","Mary","Adam"  ) ) ;

        List<Integer> ageList = new ArrayList<>(Arrays.asList(22, 25, 18));


        List<String> firstRow = new ArrayList<>(Arrays.asList("john", "22"));
        List<String> secondRow = new ArrayList<>(Arrays.asList("Mary", "25"));
        List<String> thirdRow = new ArrayList<>(Arrays.asList("Adam", "18"));

        List<List<String>> allRows
                = new ArrayList<>(Arrays.asList(firstRow, secondRow, thirdRow));


        System.out.println(allRows.get(0));
        System.out.println(allRows.get(0).get(0));
        System.out.println(allRows.get(1));
        System.out.println(allRows.get(1).get(1));

        // I want to be able to access the data using plain english

        // give me first row , Age column
        // give me third row , Name column

        // Representing table of data

        //   Name , Age , gender
        //   John   22      Male
        //   Mary   25      Female
        //   Adam   18      Male


        //  allRow.get(rowIndex).get(ColumnName)  this is the goal

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
