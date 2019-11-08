package com.leetcode.algors.ContainerWithMostWater;

import java.util.Arrays;

class Solution {

	
	// 2 ms(<95%) 40MB(<93%)
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=Integer.MIN_VALUE;
        while(i<=j){
            //int min_number=Math.min(height[i],height[j]);
            int min_number=height[i] < height[j] ? height[i] : height[j];

            //max=Math.max(max,(j-i)*min_number);
            max = max > (j-i)*min_number ? max : (j-i)*min_number;
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return max;
    }

    // 401ms - too slow
    public int maxArea2(int[] height) {
        
        int n = height.length;
        if (n==0) {
            return 0;
        }
        int maxVol = 0;
        
        for (int i=0;i<n-1;i++){
            int curShortest = height[i] < height[n-1] ? height[i] : height[n-1];
            for (int j=n-1;j>i;j--){
                if (height[j] < curShortest) {
                    continue;
                }
                curShortest = height[i] < height[j] ? height[i] : height[j];
                int curVol = (j-i) * curShortest;
                if (curVol > maxVol){
                    maxVol = curVol;
                }
            }
        }
        
        return maxVol;
    }
    
    
    
    
    // 218ms (<6%) 40MB(<94%) 
    public int maxArea3(int[] height) {
        
        int n = height.length;
        if (n==0) {
            return 0;
        }
        
        int[] volumes = new int[n];
        
        for (int i=0;i<n-1;i++) {
            int lastIndex = -1;
            int maxVol = -1;
            for (int j=i+1;j<n;j++) {
                int curVol = (height[i] >= height[j] ? height[j] : height[i]) * (j-i);
                if (curVol > maxVol){
                    maxVol = curVol;
                }
            }
            volumes[i] = maxVol;
        }
        
        Arrays.sort(volumes);
        
        return volumes[n-1];
        
    }
}