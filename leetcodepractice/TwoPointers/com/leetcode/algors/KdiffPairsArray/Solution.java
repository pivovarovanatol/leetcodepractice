package com.leetcode.algors.KdiffPairsArray;
// https://leetcode.com/problems/k-diff-pairs-in-an-array/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	
	// Another from discussions using HashMap. 13ms(<29%) 38.3MB(<100%)
    public int findPairs3(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for (int key: map.keySet()) {
            if (k > 0 && map.containsKey(key+k) || (k == 0 && map.get(key) > 1)) {
                res++;
            }
        }
        return res;
    }
	
	// from discussions. Solved with 2 Sets - for one occurrence and multiple occurrences. 7ms(<93.6%) 40.3MB(<84%)
    public int findPairs(int[] nums, int k) {
        
        if(k<0) return 0;
        Set<Integer> set1 = new HashSet<>(); // occur
        Set<Integer> set2 = new HashSet<>(); // occur >1 times
        
        for(int n:nums)
            if(k==0 && set1.contains(n)) set2.add(n);
            else set1.add(n);

        if(k==0) return set2.size();
        
        int cnt = 0;
        for(int n:set1)
            if(set1.contains(n+k)) cnt++;
        
        return cnt;
    }
	
	
	// solved with two pointers and one HashSet. 15ms(<20%) 40.4MB(<80%)
    public int findPairs2(int[] nums, int k) {
        int len=nums.length;
        int count=0;
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();

        int pointer1 = 0;
        int pointer2 = 1;
        while(pointer1 < len && pointer2 < len){
            int tmp = nums[pointer2] - nums[pointer1];
            if (tmp == k && !set.contains(nums[pointer2] +"|"+ nums[pointer1])){
                set.add(nums[pointer2] +"|"+ nums[pointer1]);
                count++;
                pointer2++;
            } else if (tmp > k){
                pointer1++;
                if (pointer1==pointer2){
                    pointer2++;
                }
            } else {
                pointer2++;
            }
            
        }
        
        return count;
    }
}