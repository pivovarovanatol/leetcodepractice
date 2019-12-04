package com.leetcode.algors.MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
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

