package com.leetcode.algors.MaximumProductOfThreeNumbers;
import java.util.Arrays;

// https://leetcode.com/problems/maximum-product-of-three-numbers/


class Solution {

    // Solved in O(n) by tracking biggest 3 and smallest 2 numbers and then comparing products. 2ms (<99.75%) 38.9MB (<100%)
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int maxNum1 = Integer.MIN_VALUE;
        int maxNum2 = Integer.MIN_VALUE;
        int maxNum3 = Integer.MIN_VALUE;
        
        int minNum1 = Integer.MAX_VALUE;
        int minNum2 = Integer.MAX_VALUE;
        
        for (int i=0;i<n;i++){
            
            if (nums[i]>maxNum3) {
                if (nums[i]>maxNum2) {
                    if (nums[i]>maxNum1){
                        maxNum3 = maxNum2;
                        maxNum2 = maxNum1;
                        maxNum1 = nums[i];
                    } else {
                        maxNum3 = maxNum2;
                        maxNum2 = nums[i];
                    }
                } else {
                    maxNum3 = nums[i];
                }
            }
            
            if (nums[i] < minNum2) {
                if (nums[i] < minNum1) {
                    minNum2 = minNum1;
                    minNum1 = nums[i];
                } else {
                    minNum2 = nums[i];
                }
            }
        }
        
        int maxPos = maxNum1 * maxNum2 * maxNum3;
        int maxNeg = minNum1 * minNum2 * maxNum1;

        return (maxPos > maxNeg ? maxPos : maxNeg);
    }

    
    
    
    // Solved with Array sort and checking last 3 and first 2 + last elements
    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums); // O(nlgn)
        int n = nums.length;
        
        int maxPos = (nums[n-3] * nums[n-2] * nums[n-1]);
        int maxNeg = nums[0] * nums[1] * nums[n-1];

        return (maxPos > maxNeg ? maxPos : maxNeg);
    }
}
