package com.leetcode.algors.MissingNumber;
// https://leetcode.com/problems/missing-number/


class Solution {
	
	// Bit manipulation.
	//Because we know that nums contains nn numbers and that it is missing exactly one number on the range [0..n-1][0..n - 1], we know that nn definitely replaces the missing number in nums. 
	//Therefore, if we initialize an integer to nn and XOR it with every index and value, we will be left with the missing number. 
	//Consider the following example (the values have been sorted for intuitive convenience, but need not be):
	//Index	0	1	2	3
	//Value	0	1	3	4
	// missing =4^(0^0)^(1^1)^(2^3)^(3^4) =(4^4)^(0^0)^(1^1)^(3^3)^2 =0^0^0^0^2 =2

	// 0ms (<100%) 39.4MB(<100%)
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
	
	// Solved with naive approach with array of booleans and 2 scans. 1ms(<44%) 39.7M(<100%)
    public int missingNumber2(int[] nums) {
     
        int n = nums.length;
        boolean[] arr = new boolean[n+1];
        
        // if (n ==0 ){
        //     return -1;
        // }
        
        
        for (int i=0;i<n;i++){
            arr[nums[i]] = true;
        }
        
        for (int i=0;i<n+1;i++){
            if (arr[i] == false) {
                return i;
            };
        }
        
        return -1;
    }
}

