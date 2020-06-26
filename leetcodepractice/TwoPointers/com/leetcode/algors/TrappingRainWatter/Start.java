package com.leetcode.algors.TrappingRainWatter;
//https://leetcode.com/problems/trapping-rain-water/

public class Start {
    
    public static void main(String[] args) {
            
    	//int[] arr = {4,2,3}; //1
    	int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1}; //6
    	//int[] arr = {4,3,2,1,0,1,2,3,4}; //16
    	//int[] arr = {2,0,2}; //2
    	// int[] arr = {4,2,0,3,2,5}; //9

        int ret = new Solution().trap(arr);
        System.out.print(ret);
    }

}
