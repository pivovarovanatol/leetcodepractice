package com.leetcode.algors.SortColors;
//https://leetcode.com/problems/sort-colors/

class Solution {

	// Solution with one-pass algorithm and O(n) space. 0ms(<100%) 35.3MB(<99%)
    public void sortColors(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        int i = 0;
        
        while (i <= end){
            while ((nums[i] == 0 && i > begin) || (nums[i] == 2 && i < end)){
                if (nums[i] == 0){
                    int tmp = nums[begin];
                    nums[begin] = nums[i];
                    nums[i] = tmp;
                    begin++;
                }
                if (nums[i] == 2){
                    int tmp = nums[end];
                    nums[end] = nums[i];
                    nums[i] = tmp;
                    end--;
                }
            }
            i++;
        }   
    }	
	
	// First Solution with counting three colors and re-writing the array with counts. 0ms (<100%) 35.1 MB(<99%)
    public void sortColors1(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        int n=nums.length;
        
        for (int i=0;i<n;i++){
            if (nums[i] == 0){
                count0++;
            } else if (nums[i] == 1){
                count1++;
            } else {
                count2++;
            }
        }
        int pointer=0;
        while (pointer<n){
            if (count0>0){
                nums[pointer] = 0;
                count0--;
            } else if (count1 > 0){
                nums[pointer] = 1;
                count1--;
            } else {
                nums[pointer] = 2;
                count2--;
            }
                
            pointer++;
        }
        
    }
}