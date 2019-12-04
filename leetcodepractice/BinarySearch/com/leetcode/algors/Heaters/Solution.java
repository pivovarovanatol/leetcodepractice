package com.leetcode.algors.Heaters;
// https://leetcode.com/problems/heaters/


import java.util.Arrays;

class Solution {
	
	// From discussions. 8ms (<90%) 40MB(<100%)
    public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		
		int minRadius = 0;
        int j=0;
		
        for(int i=0;i<houses.length;i++){
            int house=houses[i];
            
            while(j<heaters.length&&house>heaters[j])
                j++;
            j=Math.min(j,heaters.length-1);
			if(j==0) {
				minRadius=Math.max(minRadius,Math.abs(heaters[j]-house));
			} else if(j== heaters.length-1&&house>=heaters[j]) {
				minRadius=Math.max(minRadius,houses[houses.length-1]-heaters[j]);
                break;
			} else {
				minRadius=Math.max(minRadius,Math.min(house-heaters[j-1],heaters[j]-house));
			}
		}
		return minRadius;
    }
    
    
    
	// Solved with binary search. 21ms(<18%) and 40MB(<100%)
    public int findRadius2(int[] houses, int[] heaters) {
        
        Arrays.sort(heaters);
        int countHouses = houses.length; 
        //int countHeaters = heaters.length; 
        
        int maxDist = Integer.MIN_VALUE;
        
        for (int i=0; i<countHouses; i++){
            int closest = findClosestHeater(heaters, houses[i]);
            int currDist = Math.abs(heaters[closest] - houses[i]);
            if (currDist > maxDist) {
            	maxDist = currDist;
            } 
        }
        return maxDist;
    }
    
	public int findClosestHeater(int[] a, int x) {

	    int low = 0;
	    int high = a.length - 1;

	    while (low < high) {
	        int mid = (low + high) / 2;
	        int d1 = Math.abs(a[mid  ] - x);
	        int d2 = Math.abs(a[mid+1] - x);
	        
	        if (d1 == d2) {
	        	if (a[mid] > x) {
	        		high=mid;
	        	} else {
	        		low = mid + 1;
	        	}
	        } else if (d1 < d2)
	        {
	            high = mid;
	        }
	        else
	        {
	            low = mid+1;
	        }
	    }
	    return high;
	}	
    
}


