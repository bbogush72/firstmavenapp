package com.cybertek.JavaPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionReview2 {
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
        // Storing 3 Map object into another collection object
        // By default we will just use List since we dont have any restriction
        System.out.println("-------------------------");
//        allRowMaps.add(  new HashMap<>()  );
//        System.out.println( allRowMaps  );
//        allRowMaps.get(0).put("Name","John");
//        allRowMaps.get(0).put("Age","22");
//        allRowMaps.get(0).put("Gender","Male");
        //  each row data is represented by Map<ColumnName, ColumnData>
        //  we have 3 row in this case so we are storing them into a List object
        // since each item is map , so the data type will be
        // List<Map<String,String> >
        List<Map<String, String>> allRowMaps = new ArrayList<>();
        System.out.println(allRowMaps);
        // HERE we are just creating a empty table data structure
        for (int i = 0; i < 3; i++) {

            allRowMaps.add(new HashMap<>());
            allRowMaps.get(i).put("Name", "X");
            allRowMaps.get(i).put("Age", "X");
            allRowMaps.get(i).put("Gender", "X");
        }
        System.out.println(allRowMaps);
        // UPDATE 2nd ROW AGE COLUMN TO 18
        System.out.println(" 2nd ROW AGE COLUMN " + allRowMaps.get(1).get("Age"));
        allRowMaps.get(1).replace("Age", "18");
        System.out.println(allRowMaps);
        // read the data out from the map
        // print something like this :
        // row number 1 --
        //   Name --> john , age --> 18 , gender --> Male
        // and so on
        System.out.println("-------------");
        for (int i = 0; i < allRowMaps.size(); i++) {

            System.out.println("Row number " + (i + 1));
            System.out.println("Name : " + allRowMaps.get(i).get("Name"));
            System.out.println("Gender : " + allRowMaps.get(i).get("Gender"));
            System.out.println("Age : " + allRowMaps.get(i).get("Age"));
            System.out.println("-------------");
        }
//


    }
}
