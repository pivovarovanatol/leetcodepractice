package com.leetcode.algors.EmployeeImportance;
//https://leetcode.com/problems/contains-duplicate/

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

    	int[] arr = {0,1,2,3,4,5,6,7, 1};
        int result = new Solution().getImportance(null, 1);
        System.out.print(result);
    }
}