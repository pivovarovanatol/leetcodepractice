package com.leetcode.algors.ContainsDuplicates2;
import java.util.HashMap;
// https://leetcode.com/problems/contains-duplicate-ii/

class Solution {
	
	//sliding window solution - 2ms (<99%) 
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1)
            return false;
        int i = 0;
        int j = 1;
        int len = nums.length - 1;
        while(i < len && j < nums.length) {
            int delta = j - i;
            if(nums[i] == nums[j] && delta <= k)
                return true;
            if(delta < k && j < len)
                j++;
            else if (i < j - 1)
                i++;
            else {
                i++;
                j++;
            }
        }
        return false;
    }
	
	
	// Slightly faster - 8ms(<83%)
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for (int i=0;i<n;i++){
            if ((hm.containsKey(nums[i])) && (i-hm.get(nums[i]) <= k)){
                    return true;
            } 
            hm.put(nums[i],i);
        }
        
        return false;
    }
	
	
	// Solution with Map -> 9ms(<48%) 41.7MB(<94%)
    public boolean containsNearbyDuplicate4(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for (int i=0;i<n;i++){
            if (!hm.containsKey(nums[i])){
                hm.put(nums[i],i);
            } else {
                int indexOld = hm.get(nums[i]);
                if (i-indexOld <= k){
                    return true;
                } 
                hm.put(nums[i],i);
            }
        }
        
        return false;
    }
    
    
    
    
    
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int n = nums.length;
        for (int i=0;i<n-1;i++){
            int end = (i+k+1) >= n ? n : i+k+1;
            for (int j=i+1;j<end;j++){
                
                System.out.println("Indexes are: " + i + " " + j);
                
                if (nums[i]==nums[j]){
                    return true;
                }
            }
            
        }
        
        return false;
    }
	
	
	
	// Naive brutforce solution. Too slow, can't pass all tests.
    public boolean containsNearbyDuplicate5(int[] nums, int k) {
        
        int n = nums.length;
        
        
        for (int i=0;i<n-1;i++){
            int end = (i+k+1) >= n ? n : i+k+1;
            for (int j=i+1;j<end;j++){
                
                System.out.println("Indexes are: " + i + " " + j);
                
                if (nums[i]==nums[j]){
                    return true;
                }
            }
            
        }
        
        return false;
    }
}
