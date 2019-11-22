package com.leetcode.algors.MaximumProductOfThreeNumbers;

//https://leetcode.com/problems/maximum-product-of-three-numbers/


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
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    		int[] arr = {1,2,-6,3,-4,5,6};
            
            int ret = new Solution().maximumProduct(arr);
            // String out = listNodeToString(ret);
            System.out.print(ret);
    }
}

/* 
 * 000001
 *   1111
 * 010000
 * 
 * 
 * */
