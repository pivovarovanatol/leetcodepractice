package com.leetcode.algors.CombinationSum;
//https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	// solved with recursion and gradually reducing the target.  22 ms (<7%) 42MB(<5%)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // brute force with recursion/backtracking
        // get the candidate. then deduct candidate from target and repeat. once reached 0 -> add to the possible combination list.
        Set<List<Integer>> results = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        checkCandidates(0, target, candidates, results, list);
        
        for (List r : results){
            result.add(r);
        }
        return result;
    }
    
    void checkCandidates(int num, int target, int[] candidates,   Set<List<Integer>> results, List<Integer> list){
        // reached the target -> add to a list and to result
        if (target - num > 0){
            int newTarget = target - num;
            for (int candidate : candidates){
                if (candidate <= newTarget){
                    list.add(candidate);
                    checkCandidates(candidate, newTarget, candidates, results, list);   
                    list.remove(list.size()-1);
                }
            }
        } else if (target - num == 0) {
            List<Integer> newList = new ArrayList<>(list);
            Collections.sort(newList);
            //System.out.println("Adding the new result for candidate: " + num);
            if (!results.contains(newList)) results.add(newList);
        }
        
    }
    
}
