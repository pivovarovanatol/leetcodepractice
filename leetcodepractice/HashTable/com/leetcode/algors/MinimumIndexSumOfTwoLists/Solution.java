package com.leetcode.algors.MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

class Solution {
	
	// Solved optimally with 2 loops and 1 HashMap O(N) time and O(N) space. 8ms (<85%) and 38.5MB(<100%)
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;
        int minSum = Integer.MAX_VALUE;
        
        HashMap<String, Integer> map1 = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        for (int i=0;i<len1;i++){
            map1.put(list1[i], i);
        }
        
        for (int i=0;i<len2;i++){
            if (map1.containsKey(list2[i])){
                int currSum = map1.get(list2[i]) + i;
                
                if (currSum < minSum){
                    minSum = currSum;
                    result.clear();
                    result.add(list2[i]);
                } else if (currSum == minSum){
                    result.add(list2[i]);
                }
            }
        }
        
        return result.toArray(new String[result.size()]);
    }

	// Solved sub optimally with 3 loops and 2 HashMaps. 10ms (<40%) and 39.5MB(<90%) 
    public String[] findRestaurant2(String[] list1, String[] list2) {
        
        int len1 = list1.length;
        int len2 = list2.length;
        int minSum = Integer.MAX_VALUE;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        for (int i=0;i<len1;i++){
            map1.put(list1[i], i);
        }
        
        for (int i=0;i<len2;i++){
            if (map1.containsKey(list2[i])){
                int currSum = map1.get(list2[i]) + i;
                map2.put(list2[i], currSum);
                if (currSum < minSum){
                    minSum = currSum;
                }
            }
        }
        
        for (String key : map2.keySet()){
            if (map2.get(key) == minSum){
                result.add(key);   
            }
        }
        
        
        return result.toArray(new String[result.size()]);
    }
}

