package com.cybertek.JavaPractice;

import com.cybertek.Utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArrayListPractice extends TestBase {

    public static void main(String[] args) {


        List<String> expectedColumnNames = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");

        //added column names in sorted list
        List<String> sorted = new ArrayList<>();
        sorted.addAll(expectedColumnNames);
        System.out.println(sorted);
        // use Collections class to sort all elements
        Collections.sort(sorted);
        System.out.println(sorted);

        // WebElement tableSize = driver.

        //get column data
        int colNumber = 0;
        for (int i = 0; i < expectedColumnNames.size(); i++) {


        }
    }


}
