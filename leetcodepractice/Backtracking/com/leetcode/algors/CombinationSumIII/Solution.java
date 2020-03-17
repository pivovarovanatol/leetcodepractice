package com.leetcode.algors.CombinationSumIII;
//https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.List;

class Solution {
    // solved with brute force recursive algo. 0ms (<100%)
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getCombinations(k, n, res, list, 1);
        
        return res;
    }
    
    void getCombinations(int k, int n, List<List<Integer>> res, List<Integer> list, int start){
        // base cases for recursion. Return if either running sum or running count is below 0 
        if (n<0) return;
        if (k<0) return;
        
        // if sum is 0 and count 0 -> found the combination, adding to the resulting list
        if (n == 0 && k == 0){
            List<Integer> l = new ArrayList<>();
            for (int e : list) l.add(e);
            res.add(l);
            return;
        }
        
        // looping over
        for (int i=start; i<=9;i++){
            list.add(i);
            getCombinations(k-1, n-i, res, list, i+1);
            list.remove(list.size()-1);
        }
    }    
}