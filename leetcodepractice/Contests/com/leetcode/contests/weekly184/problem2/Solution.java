package com.leetcode.contests.weekly184.problem2;
// https://leetcode.com/problems/queries-on-a-permutation-with-key/

class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] nums = new int[m];
        int[] positions = new int[m];
        int[] result = new int[queries.length];
        int ind =0;
        for (int i=0;i<m;i++){
            positions[i]=i;
            nums[i]=i+1;
        }   
        
        for (int i=0;i<queries.length;i++){
            int element = queries[i];
            int curPos = positions[element-1];
            positions[element-1] = -1;
            result[ind] = curPos;
            ind++;
            
            for (int j=0;j<m;j++){
                if (positions[j]<curPos) positions[j]++;
            }
        }
        
        
        return result;
    }
}