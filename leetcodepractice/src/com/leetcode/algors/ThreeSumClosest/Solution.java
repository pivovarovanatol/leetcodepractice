package com.leetcode.algors.ThreeSumClosest;
// https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

class Solution {
	
	// Same as Three Sum problem - solution with 2 pointers and check for duplicates - 3ms (<98%) 36.1MB(<100%) 
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int d = Integer.MAX_VALUE;
        int l, r, a, b ,c;
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                l = i + 1;
                r = nums.length-1;
                while(l < r){
                    a = nums[i]; b = nums[l]; c = nums[r];
                    int total = a + b + c;
                    if(total == target) return total;
                    else if(total > target){
                        if(total - target < d){
                            d = total - target;
                            res = total;
                        }
                        r--;
                    }else{
                        if(-total + target < d){
                            d = -total + target;
                            res = total;
                        }
                        l++;
                    }
                }
            }
        }
        return res;
    }
	
	// Naive solution with 3 loops - surprisingly accepted with 21ms(<11%) and 36.2MB (<100%)
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        int n = nums.length;
        int closest = 0;
        
        for (int i=0;i<n-2;i++){
            for (int j=i+1;j<n-1;j++){
                for (int k=j+1;k<n;k++) {
                    int currDelta = Math.abs(target - (nums[i]+nums[j]+nums[k]));
                    // System.out.println(nums[i]+ " " + nums[j]+ " " + nums[k] + " = " + (nums[i]+nums[j]+nums[k]) + " delta is " + currDelta);
                    if (currDelta < delta){
                        delta = currDelta;
                        closest = (nums[i]+nums[j]+nums[k]);
                    }
                    if (delta == 0){
                        break;
                    }
                }
                    if (delta == 0){
                        break;
                    }
            }
                    if (delta == 0){
                        break;
                    }
        }
        
        return closest;
    }
}