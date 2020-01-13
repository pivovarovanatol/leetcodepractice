package com.leetcode.algors.IntersectionTwoArrays2;
// https://leetcode.com/problems/intersection-of-two-arrays-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
	
	
	// from discussions. Array List + Binary Search. When found one occurrence - remove to properly calculate duplicates. 3ms(<53%) 38.2MB(<19%)
	 public int[] intersect(int[] nums1, int[] nums2) {
	        Arrays.sort(nums1);
	        
	        List<Integer> nums1List = new ArrayList<>();
	        
	        for (int num : nums1)
	            nums1List.add(num);
	        
	        List<Integer> ret = new LinkedList<>();
	        
	        for (int num: nums2) {
	            int idx = search(nums1List, num);
	            if (idx != -1) {
	                nums1List.remove(idx);
	                ret.add(num);
	            }
	        }
	        
	        int[] retArr = new int[ret.size()];
	        
	        int i = 0;
	        
	        for (int num : ret) {
	            retArr[i++] = num;
	        }
	        
	        return retArr;
	        
	    }
	    
	    
	    public int search(List<Integer> nums, int key) {
	        int high = nums.size()-1, low = 0;
	        
	        while (low <= high) {
	            int mid = low + (high - low) / 2;
	            if (nums.get(mid) == key)
	                return mid;
	            else if (nums.get(mid) > key)
	                high = mid - 1;
	            else
	                low = mid + 1;
	        }
	        
	        return -1;
	    }
	
	// solved with 2 HashMaps and count of elements. 7ms(<10%) 37.2MB(<84%)
    public int[] intersect3(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int e : nums1){
            if (map1.containsKey(e)){
                int tmp = map1.get(e);
                map1.put(e,tmp+1);
            } else {
                map1.put(e,1);
            }
        }

        for (int e : nums2){
            if (map2.containsKey(e)){
                int tmp = map2.get(e);
                map2.put(e,tmp+1);
            } else {
                map2.put(e,1);
            }
        }

        for (int key : map1.keySet()){
            if (map2.containsKey(key)){
                int count1 = map1.getOrDefault(key,0);
                int count2 = map2.getOrDefault(key,0);
                int i=Math.min(count1, count2);
                while (i>0){
                    result.add(key);
                    i--;
                }
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
	
	// solved with Arrays sort and two pointers. 15ms(<5.6%) 38MB(<19%)
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0;
        int pointer2=0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while (pointer1<nums1.length && pointer2<nums2.length){
            if(nums1[pointer1]==nums2[pointer2]){
                System.out.println(nums1[pointer1] + " " + nums2[pointer2]);
                result.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            } else if (nums1[pointer1]<nums2[pointer2]) {
                pointer1++;
            } else if (nums1[pointer1]>nums2[pointer2]){
                pointer2++;
            }
        }
     
        return result.stream().mapToInt(i -> i).toArray();
    }
}