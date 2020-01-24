package com.leetcode.algors.OptimalDivision;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/optimal-division/


class Solution {
	// From discussions: 0ms(<100%) 40MB(<25%) 
    public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                builder.append("/(").append(nums[i]);
            } else {
                builder.append("/").append(nums[i]);
            }
        }
        
        return nums.length > 2 ? builder.append(")").toString() : builder.toString();
    }

	
    // Math + string composition. 6ms(?)
    public String optimalDivision1(int[] nums) {
        int n=nums.length;
        if (n==0){
            return "";
        }        
        
        if (n==1){
            return Integer.toString(nums[0]);
        }        
        
        
        if (n==2){
            String result = Arrays.stream(nums)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("/"));
            return result;
        } else {
            String result = Arrays.stream(nums)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("/"));
            int index = result.indexOf('/');
            result = new StringBuilder(result).insert(index+1, '(').append(')').toString();
            return result;
        }
    }        
    
    // Solved with brute force in 1ms(<48%) 38.5MB(<25%)
    public String optimalDivision2(int[] nums) {
        int n=nums.length;
        if (n==0){
            return "";
        }        
        
        if (n==1){
            return Integer.toString(nums[0]);
        }        
        
        //String result;
        
        float part1=nums[0]*nums[0];
        float part2=1;
        float val=0;
        int index=0;
        // Calc index where to put the parenthesis
        for (int i=0;i<n-1;i++){
            part1 /= nums[i];
            part2 = nums[i+1];
            for (int j=i+2;j<n;j++){
                //System.out.println("Part2: " + part2);
                part2 /=nums[j];
            }
            //System.out.println(part1 + " / " + part2 + " = " + part1/part2);
            
            if (part2 > 0 && part1/part2 > val){
                val = part1/part2;
                index = i;
            }
        }
        
        // Creating the string
        StringBuilder sb = new StringBuilder();
        
        for (int i=0;i<=index;i++){
            sb.append(nums[i]).append('/');
        }
        if (index < n-2) sb.append('(');
        for (int i=index+1;i<n;i++){
            sb.append(nums[i]);
            if (i<n-1) sb.append('/');
        }
        if (index < n-2) sb.append(')');
        
        //result = sb.toString();
        
        return sb.toString();
        
    }
}
