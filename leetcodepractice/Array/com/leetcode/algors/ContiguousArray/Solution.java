package com.leetcode.algors.ContiguousArray;
// https://leetcode.com/problems/contiguous-array/


import java.util.HashMap;

class Solution {
	// from discussions. 4ms(<99%)
    public int findMaxLength(int[] nums) {
        int N=nums.length, locs[] = new int[N+N+1], max=0, count=0;
        
        for( int i=0; i<N; i++ ) {
            count+=(nums[i]+nums[i]-1);
            if( locs[count+N]==0 && count!=0 ) locs[count+N]=i+1;
            max=Math.max( max, i+1-locs[count+N] );
        }
		
        return max;
    }
	
    // from discussions. 29ms (<12%)
    public int findMaxLength1(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // right - left = 0 -> left = right. Since left = right, let's name it sum
        int ans = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }
        return ans;
    }
	
	
    // do brute force - TLE
    public int findMaxLength2(int[] nums) {
        int maxLen = 0;
        
        for (int i=0;i<nums.length;i++){
            int count = 0;            
            for (int j=i;j<nums.length;j++){
                if (nums[j]==1) count++;
                else count--;

                if (count == 0) maxLen = Math.max(maxLen, (j-i+1));
            }
        }
        
        return maxLen;
    }
}

