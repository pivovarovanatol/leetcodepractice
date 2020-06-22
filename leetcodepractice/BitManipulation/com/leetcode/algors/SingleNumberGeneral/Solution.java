package com.leetcode.algors.SingleNumberGeneral;

class Solution {
    public int singleNumberAmoungTripls(int[] nums) {
      int ones = 0, twos = 0, threes = 0;

      for (int i = 0; i < nums.length; i++) {
        // twos holds the num that appears twice
        twos |= ones & nums[i];

        // ones holds the num that appears once
        ones ^= nums[i];

        // threes holds the num that appears three times
        threes = ones & twos;

        // if num[i] appears three times
        // doing this will clear ones and twos
        ones &= ~threes;
        twos &= ~threes;
      }
      return ones;
    }

    
    
    public int singleNumberAmoungDoubles(int[] nums) {
        int s = 0;

        for (int i = 0; i < nums.length; i++) {
        	s ^= nums[i];
        }
        return s;
      }
    
    public int[] twoSingleNumbersAmoungDoubles(int[] nums) {
        int A = 0;  
        int B = 0;  
        int AXORB = 0;  
        for(int i = 0; i<nums.length; i++){  
            AXORB ^= nums[i];  
        }  
          
        AXORB = (AXORB & (AXORB - 1)) ^ AXORB; //find the least significant different bit in A and B and set it to 1
        
        // go over entire array again and split all the elements in 2 buckets according to that bit. 
        // eventually all duplicated numbers will XOR itself to 0 leaving only 2 numbers in 2 buckets - numbers we were looking for 
        for(int i = 0; i<nums.length; i++){  
            if((AXORB & nums[i]) == 0)  
                A ^= nums[i];  
            else  
                B ^= nums[i];  
        }  
        return new int[]{A, B};  
    }



}