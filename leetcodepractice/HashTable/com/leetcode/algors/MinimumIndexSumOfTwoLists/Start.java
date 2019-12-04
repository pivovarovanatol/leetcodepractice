package com.leetcode.algors.MinimumIndexSumOfTwoLists;
// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

import java.io.IOException;

public class Start {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    

    public static void main(String[] args) throws IOException {

    	String[] arr1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    	String[] arr2 = {"KFC", "Shogun", "Burger King"};
        String[] result = new Solution().findRestaurant(arr1, arr2);
        System.out.print(result);
    }
}