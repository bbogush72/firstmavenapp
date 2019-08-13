package com.cybertek.JavaPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JavaInterviewQuestions {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, 100, 98, 10};
        sortArrayWithoutArraysSortMethod(numbers);
        Map<String, Integer> myMap = countLetters("level");
        System.out.println(myMap);
    }

    // How do you sort an Array without using Arrays.sort(); method
    /*
            int [] nums = {5, 6, 7, 2, 333, 66};
     */
    public static void sortArrayWithoutArraysSortMethod(int[] nums) {
        int temp;
        for (int idx = 0; idx < nums.length; idx++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    // String name = "Khalili";
    // write a method which explains how many times each letter is repeated?
    // K = 1; , h = 1; a = 1; l = 2; i = 2;
    public static Map<String, Integer> countLetters(String name) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        char[] ch = name.toCharArray();
        for (char c : ch) {
            String result = c + "";
            if (!map.containsKey(result)) {
                map.put(result, 1);
            } else {
                map.put(result, result.length() + 1);
            }
        }
        return map;
    }
}



